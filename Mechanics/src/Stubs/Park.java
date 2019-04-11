/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.MechanicsPark;
import genclass.GenericIO;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class Park implements MechanicsPark{
    private String server;
    private int port;
    
    public Park(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    /**
     * To signal the return of the vehicle to the parking lot, the index of the position 
     * of the array corresponds to the id of the car, and the value of that position is set to 1.
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
        com.close();
        
    }
    
    /**
     * To signal the output of the parking vehicle, that vehicle is removed from the array of cars
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
        com.close();
        
    }
    
    public void blockVehicle(int car){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.BLOCK_VEHICLE, car);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
    }
}
