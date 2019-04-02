/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import EntitiesState.ManagerState;
import Interfaces.ManagerLounge;
import MainPackage.Manager;

/**
 *
 * @author danielmartins
 */
public class Lounge implements ManagerLounge {

    private final String server;
    private final int port;
    
    public Lounge(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    
    public boolean getNextTask(){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        }
        
        Message msg = new Message(MessageType.GET_NEXT_TASK);
        
        Manager manager = (Manager)Thread.currentThread();
        manager.setManagerState(ManagerState.CHECKING_WHAT_TO_DO);
        
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        com.close ();
        return true;
    }
    
    /**
     * Choose what is the new task (Lounge)
     * @return int 
     */
    public String appraiseSit(){
        return "";
    }
    
    /**
     * Talk to Customer (Lounge)
     */
    public void talkToCustomer(String info){
        
    }
    
    /**
     * Receive Payment (Lounge)
     */
    public void receivePayment(String info){
        
    }
    
    /**
     * Hand Car Key (Lounge)
     */
    public void handCarKey(String customer){
        
    }
}
