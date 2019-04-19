/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Stubs.GeneralInformationRepo;
import static MainPackage.Constants.NUM_CUSTOMERS;
import genclass.GenericIO;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import MainPackage.MainProgram;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class Park {
    
    /**
     * Logger class for debugging.
     */
    private GeneralInformationRepo logger;
    
    /**
     * Replacement Car Kit
     */
    private Queue<Integer> replacementCars = new LinkedList<Integer>() {{add(-1); }};
    
    /**
     * Set of parked cars
     */
    private ArrayList<Integer> cars = new ArrayList<>();
    
    /**
     * Set of repaired cars.
     */
    private int[] repairedCars = new int[NUM_CUSTOMERS];  

    public Park(GeneralInformationRepo logger) {
        this.logger = logger;
    }

    private boolean []CustomersInWait = new boolean[NUM_CUSTOMERS];
    
    /**
     * The customer park the car in the park.
     * In this state you can get in, 
     * customers who will repair a car, 
     * customers who will get the car after repair and who has a replacement car.
     * @param info customer's info
     * @param customerState customer's state
     */
    public synchronized void goToRepairShop(String info, String customerState) {
        /**
         * Content of info :
         *      id.carId.currentCar.wantsCar.wantsToPay
         */
        String[] inf = info.split(",");
        logger.setCustomerState(Integer.parseInt(inf[0]), customerState);
        logger.setOwnCar(Integer.parseInt(inf[0]), info);
        
        /**
         * If his current car is different from your car id => if ( currentCar != carId )
         * it means that the current car is a replacement car, he waits.
         */
        if ( !inf[2].equals(inf[1])){ 
            replacementCars.add(Integer.parseInt(inf[2])); 
            notifyAll();
        }
        /**
         * If the car is repared and his current car is different from your car id, => if ( currentCar == carId )
         * it means that the current car is a replacement car, he wait.
         */        
        else if ( inf[2].equals(inf[1]) ){ 
            cars.add(Integer.parseInt(inf[1])); 
            notifyAll();
        }
        GenericIO.writelnString("Customer "+info+" go to repair Shop");
    }

    /**
     * Method used by the customer to search for a replacement car
     * Each customer will poll the list of replacement cars, and 
     * if there are no cars, they wait.
     * @param id customer's id
     * @param customerState customer's state
     * @return replacement car
     */
    public synchronized int findCar(int id, String customerState) {
        logger.setCustomerState(id, customerState);
        /**
         * If the list of replacement car is not empty, he give a car to the customer.
        */
        int wait = 0;
        while (replacementCars.isEmpty() ){
            try {
                /**
                 * If the list of replacement car is empty, he's wait for a car.
                 */
                CustomersInWait[id] = true;
                wait = 0;
                for(boolean x : CustomersInWait)
                    if (x == true){
                        wait++;
                        logger.setNumberWaitingReplece(wait);
                    }
                
                wait();
            } catch (InterruptedException ex) {
                GenericIO.writelnString("findCar - Customer thread was interrupted.");
                System.exit(1);
            }
        }
             
        CustomersInWait[id] = false;          
        notifyAll();
        GenericIO.writelnString("Customer "+id+" find car");
        return replacementCars.poll();
    }

    /**
     * Method to signal when a car is repaired, signaling the position 
     * with the index equal to the car id, with a value of 1.
     * @param car customer's car id
     * @param customerState customer's state
     */
    public synchronized void collectCar( int car , String customerState ) {
        
        /**
         * If the list of repairedCards contains your car
         * repairedCars[car] == 0    => car not repaired
         * repairedCars[car] == 1    => car repaired
         * repairedCars[car] == -1   => car collected
         */
        logger.setCustomerState(car, customerState);
        logger.setAlreadyRepaired(car, repairedCars);

        if (repairedCars[car] == 1){
            repairedCars[car] = -1;            
        }
        notifyAll();
        GenericIO.writelnString("Customer "+car+" collect car");
    }
    /**
     * To signal the return of the vehicle to the parking lot, the index of the position 
     * of the array corresponds to the id of the car, and the value of that position is set to 1.
     * @param car customer's car id
     */
    public synchronized void returnVehicle(int car) {
        repairedCars[car] = 1;
        notifyAll();
        GenericIO.writelnString("Mechanic return Vehicle from "+car);   
    }
    
    /**
     * To signal the output of the parking vehicle, that vehicle is removed from the array of cars
     * @param car customer's car id
     */
    public synchronized void getVehicle(int car) {
        assert cars.contains(car);
        cars.remove(Integer.valueOf(car));
        notifyAll();
        GenericIO.writelnString("Mechanic get Vehicle from "+car);           
    }

    /**
     * To signal the block of the parking vehicle, that vehicle is added to array of cars
     * @param car customer's car id
     */    
    public synchronized void blockVehicle(int car){
        cars.add(car);
        notifyAll();
        GenericIO.writelnString("Mechanic block Vehicle from "+car);           
    }

    /**
     * Terminate the outsideWorld service.
     */
    public synchronized void serviceEnd(){
        MainProgram.serviceEnd = true;
        notifyAll();
        GenericIO.writelnString(" Park will end");   
    }     
   
}
