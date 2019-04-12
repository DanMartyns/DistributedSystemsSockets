/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.CustomerOutSideWorld;
<<<<<<< HEAD
=======
import static MainPackage.Constants.NUM_CUSTOMERS;
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
import genclass.GenericIO;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class OutsideWorld implements CustomerOutSideWorld {
   
    /**
     * Name of the computational system where it is located the server.
     */
    private final String server;

    /**
     * Number of server listening port.
     */
    private final int port;
    
    public OutsideWorld(String server, int port) {
        this.server = server;
        this.port = port;
        
    }

   

    /**
     * Decide whether to get the car or not.
     * @param customer
     * @param customerState
     * @return true or false, if he wants or not
     */
    public boolean decideOnRepair(int customer, String customerState) {
        ClientCom com = new ClientCom (server, port);
        
         while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.DECIDE_ON_REPAIR, customer, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
<<<<<<< HEAD
        if ( inMessage.getType() != MessageType.RETURN_DECIDE_ON_REPAIR ){
=======
        if ( inMessage.getType() != MessageType.STATUS_OK ){
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
            GenericIO.writelnString("decideOnRepair - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
        
<<<<<<< HEAD
        return inMessage.isDecideOnRepair();
=======
        return true;
>>>>>>> de47baa29e1030af050f241539cb9a20afa32692

    }

    /**
     * Synchronization point.
     * Get back to your normal life without a car. 
     * It waits to be notified that your car is repaired.
     * @param customer
     * @param customerState
     */
    public void backToWorkByBus(int customer, String customerState) {
        ClientCom com = new ClientCom (server, port);
        
         while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.BACK_TO_WORK_BY_BUS, customer, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("backToWorkByBus - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
        
        

    }
    /**
     * Synchronization point.
     * Get back to your normal life with your car after it's fixed 
     * or with a replacement car. If he is with a replacement car, 
     * he waits to be notified that his car is repaired.
     * @param info 
     * @param customerState 
     */
    public void backToWorkByCar(String info, String customerState) {
        ClientCom com = new ClientCom (server, port);
        
         while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.BACK_TO_WORK_BY_CAR, info, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("backToWorkByCar - Manager thread was interrupted.");
            System.exit(1);                     
        }        
        
        com.close ();
        

    }
         
}
