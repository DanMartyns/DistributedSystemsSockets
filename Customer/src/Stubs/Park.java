/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.CustomerPark;
import genclass.GenericIO;


/**
 * @author danielmartins
 * @author giselapinto
 */
public class Park implements CustomerPark{
    
    /**
     * Name of the computational system where it is located the server.
     */
    private final String server;

    /**
     * Number of server listening port.
     */
    private final int port;
    

    public Park(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    /**
     * The customer park the car in the park.
     * In this state you can get in, 
     * customers who will repair a car, 
     * customers who will get the car after repair and who has a replacement car.
     * @param info
     * @param customerState
     */
    public void goToRepairShop(String info, String customerState) {
        
        ClientCom com = new ClientCom (server, port);
        
         while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.GO_TO_REPAIR_SHOP, info, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("goToRepairShop - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
       
    }

    /**
     * Method used by the customer to search for a replacement car
     * Each customer will poll the list of replacement cars, and 
     * if there are no cars, they wait.
     * @param id
     * @param customerState
     */
    public int findCar(int id, String customerState) {
       ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.FIND_CAR, id, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("findCar - Manager thread was interrupted.");
            System.exit(1);                     
        }  
        com.close();
<<<<<<< HEAD
        return inMessage.getCustomerID();
=======
        return inMessage.getCarId();
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
       
       
    }

    /**
     * Method to signal when a car is repaired, signaling the position 
     * with the index equal to the car id, with a value of 1.
     * @param car
     * @param customerState
     */
    public void collectCar( int car , String customerState ) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.COLLECT_CAR, car, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("collectCar - Manager thread was interrupted.");
            System.exit(1);                     
        }  
        com.close();
        
    }
<<<<<<< HEAD
=======
    /**
     * To signal the return of the vehicle to the parking lot, the index of the position 
     * of the array corresponds to the id of the car, and the value of that position is set to 1.
     * @param car
     */
    public void returnVehicle(int car) {
       ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.RETURN_VEHICLE, car);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("returnVehicle - Manager thread was interrupted.");
            System.exit(1);                     
        }  
        com.close();
    }
    
    /**
     * To signal the output of the parking vehicle, that vehicle is removed from the array of cars
     * @param car
     */
    public void getVehicle(int car) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.GET_VEHICLE, car);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("getVehicle - Manager thread was interrupted.");
            System.exit(1);                     
        }  
        com.close();
        
    }
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
}
