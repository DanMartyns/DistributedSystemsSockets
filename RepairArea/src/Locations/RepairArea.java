/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Stubs.GeneralInformationRepo;
import MainPackage.Constants;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class RepairArea {

    /**
     * Logger class for debugging.
     */
    private GeneralInformationRepo logger;

    /**
     * The queue of services registered by the manager
     */
    private Queue<Integer> services = new LinkedList<>();
    
    private Map<Integer,String> blockedServices = new HashMap<>();
    
    /**
     * Count completed jobs
     */
    private boolean shutdown = false;

    
    public RepairArea(GeneralInformationRepo logger) {
        this.logger = logger;
    }

    /**
     * The mechanic remains in the "read paper" state, while the lists is empty. If not, continue
     * @param mechanic mechanic id
     * @param mechanicState the state of the mecaninc
     * @return the service who'll do
     */    
    public synchronized String readThePaper(int mechanic, String mechanicState) {
        
        logger.setMechanicState(mechanic, mechanicState);   
        
        while ( blockedServices.isEmpty() && services.isEmpty() && shutdown == false ){
            try {
                wait();
            } catch (InterruptedException ex) {
                System.exit(1);
            }
        }
        String service;        
        if (!blockedServices.isEmpty()){
            Map.Entry<Integer,String> entry = blockedServices.entrySet().iterator().next();
            int key = entry.getKey();
            String value = entry.getValue();
            service = key+","+value;
            blockedServices.remove(key,value);
   
        } else {
            service = services.poll()+",-1";
        }
        if(shutdown){
            service = "end";
        }
       notifyAll();
       return service;
    }
    
    /**
     * The manager records the repair of a car. 
     * @param info the information about customer
     * @param managerState the state of the manager
     */
    public synchronized void registerService(String info, String managerState) {
        int customer = Integer.parseInt(info.split(",")[0]);
        /**;
         * Register a service, means register the customer id
         * */
        services.add( customer );
        logger.setManagerState(managerState);
        logger.setNumberServiceRequest(services.size());       
        notifyAll();
    }

    /**
     * In terms of simulation, indicates the service to be done
     * Transition state
     * @param mechanic mechanic id
     * @param mechanicState the state of the mecaninc
     */
    public synchronized void startRepairProcedure(int mechanic, String mechanicState) {
        logger.setMechanicState(mechanic,mechanicState);
    }

    /*
    * Theoretically the mechanic will find out which part is missing from the car
    * A random value is generated to indicate the part missing from the car
    * @param mechanic mechanic id
    * @param mechanicState the state of the mecaninc
    */
    public synchronized String getRequiredPart(int mechanic, String mechanicState) {       
        logger.setMechanicState(mechanic, mechanicState);        
        /**
          * 0 - piece A
          * 1 - piece B
          * 2 - piece C
          */
        int min = 0;
        int max = 2;
        return ""+(int)(Math.random() * ((max) + 1));
    }

    /*
    * Checking the stock 
    * If there are no parts, the car is locked and is passed to a next service
    * @param piece type of piece
    * @param car car id
    * @return true or false, if mechanics has parts with him or not
    */
    public synchronized boolean partAvailable(String piece, int car) {       
        logger.setPiecesAvabal(piece);
        if (piece.equals("0") && Constants.pieceA <= 1 || piece.equals("1") && Constants.pieceB <= 1 || piece.equals("2") && Constants.pieceC <= 1){
            blockedServices.put(car, piece);
            return false;
        } else
            return true;
    }
    /*
    * Decreases the number of pieces after verifying that they have
    */
    public synchronized void resumeRepairProcedure(String piece, int mechanic, String mechanicState) {
        logger.setMechanicState(mechanic, mechanicState); 
        logger.setPieces0Stored(Constants.pieceA);
        logger.setPieces1Stored(Constants.pieceB);
        logger.setPieces2Stored(Constants.pieceC);
        
        if (piece.equals("0") )
            Constants.pieceA--;
        if (piece.equals("1") )
            Constants.pieceB--;
        if (piece.equals("2") )
            Constants.pieceC--;    
       
    }

    /*
    * Process the fix the car from customer
    * Transitional State
    */
    public synchronized void fixIt() {
    }
    
    /**
     * Function called by the manager to replace parts, according to a part and quantity.
     * @param peca piece's type
     * @param quantidade total number of pieces
     * @param managerState the state of the manager
     */
    public synchronized void storePart(String peca, int quantidade, String managerState) {
        logger.setManagerState(managerState);
        if ( peca.equals("0") ){
            Constants.pieceA = Constants.pieceA + quantidade;
            logger.setPieces0Manager(Constants.pieceA);
        }
        if ( peca.equals("1") ) {
            Constants.pieceB = Constants.pieceB + quantidade;
            logger.setPieces1Manager(Constants.pieceB);
        }

        if ( peca.equals("2") ){
            Constants.pieceC = Constants.pieceC + quantidade;
            logger.setPieces2Manager(Constants.pieceC);
        }
    }
    /**
     * Fuction to shutdown the repair area
     * @param managerState the manager state
     */
    public synchronized void shutdownNow(String managerState){
        logger.setManagerState(managerState);
        this.shutdown = true;
        notifyAll();
    }
     
}
