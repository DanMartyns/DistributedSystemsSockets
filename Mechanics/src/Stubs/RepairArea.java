/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.MechanicsRepairArea;
import genclass.GenericIO;
import java.util.Map;
/**
 * @author danielmartins
 * @author giselapinto
 */
public class RepairArea implements MechanicsRepairArea {
    
    private String server;
    private int port;
    

    public RepairArea(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    public String readThePaper(int mechanic, String mechanicState) {
    
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.READ_THE_PAPER, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        if ( inMessage.getType() != MessageType.RETURN_READ_THE_PAPER ){
            GenericIO.writelnString("readThePaper - Manager thread was interrupted.");
            System.exit(1);                     
        }
        
        return inMessage.getStr1();
    }


    /**
     * In terms of simulation, indicates the service to be done
     * Transition state
     */
    public void startRepairProcedure(int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.START_REPAIR_PROCEDURE, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
    }
    
    public void fixIt(){
         ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.FIX_IT);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }

    /*
    * Theoretically the mechanic will find out which part is missing from the car
    * A random value is generated to indicate the part missing from the car
    */
    public String getRequiredPart(int mechanic, String mechanicState) {       
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.GET_REQUIRED_PART, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
        return inMessage.getStr1();
    }

    /*
    * Checking the stock 
    * If there are no parts, the car is locked and is passed to a next service
    * @return true or false, if mechanics has parts with him or not
    */
    public boolean partAvailable(String piece, int car) {       
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.PART_AVAILABLE, car, piece);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        return inMessage.isBoolean1();
    }
    
    /*
    * Decreases the number of pieces after verifying that they have
    */
    public void resumeRepairProcedure(String piece, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.RESUME_REPAIR_PROCEDURE, piece, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
       
    }
}
