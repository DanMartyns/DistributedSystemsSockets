/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.*;
import genclass.GenericIO;
import java.util.*;

/**
 * @author danielmartins
 * @author giselapinto
 */
public class Lounge implements MechanicsLounge {

    private String server;
    private int port;
     
    public Lounge(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
     
    /**
    * Let manager know that the mechanics needs more pieces from supplier site
    * @param peca pecas
    * @param mechanics 's id
    * @param mechanicState state
    **/
    public void letManagerKnow(String peca, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.LET_MANAGER_KNOW, peca, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();

    }
    
    /**
    * Notify the repair is concluded
    * @param currentCar id of current car
    * @param mechanics 's id
    * @param mechanicState state
    **/
    public void repairConcluded(int currentCar, int mechanic, String mechanicState) {
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.REPAIR_CONCLUDED, currentCar, mechanic, mechanicState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
    }
    
    public boolean checkRequest(String peca){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }    
        Message msg = new Message(MessageType.CHECK_REQUEST, peca);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close();
        
        return true;
    }
}
