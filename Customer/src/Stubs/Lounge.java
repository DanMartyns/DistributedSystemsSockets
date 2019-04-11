/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import genclass.GenericIO;
import Communication.ClientCom;
import Communication.Message;
import Communication.MessageType;
import Interfaces.CustomerLounge;

/**
 * Lounge stub. Class used to communicate with the Lounge
 * using TCP communication channels.
 * @author danielmartins
 */
public class Lounge implements CustomerLounge {

    /**
     * Name of the computational system where it is located the server.
     */
    private final String server;

    /**
     * Number of server listening port.
     */
    private final int port;
    
    /**
     *  Stub instatiation.
     *
     *    @param server Name of the computational system where it is located the server.
     *    @param port Number of server listening port.
     */    
    public Lounge(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    /**
     * The costumer go into the Lounge and waits for his turn
     * @param id
     * @param customerState
     */
    public void queueIn(String id, String customerState){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.QUEUE_IN, id, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("queueIn - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();  
    
    }
    
    /**
     * In theoretical terms, the client spends some time talking to the manager.
     * In practical terms, it is a synchronization point where the client updates the "talkBetweenManCust" 
     * variable to false if that client is the client that the manager initiated a conversation.
     * If the variable is already false, it means that the manager has not started a conversation 
     * yet and therefore expects the manager to respond.
     * @param customer
     */
    public void talkWithManager(int customer){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.TALK_WITH_MANAGER, customer);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("talkWithManager - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();    
    }
    
    /**
     * Synchronization point.
     * In theoretical terms, you will receive the key to the replacement car.
     * In practical terms, synchronization will only be done using the key variable.
     * @param customer
     * @param customerState
     */
    
    public void collectKey(int customer, String customerState){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.COLLECT_KEY, customer, customerState);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("collectKey - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();    
    }

    /**
     * In theoretical terms will effect the payment.
     * In practical terms, it is just a state of transition.
     * @param customer
     */
    public void payForTheService(int customer){
        ClientCom com = new ClientCom (server, port);
        
        while(!com.open()){
            try {
                Thread.currentThread ().sleep ((long) (10));
            } catch (InterruptedException ex) {}
        } 
        Message msg = new Message(MessageType.PAY_FOR_THE_SERVICE, customer);
        com.writeObject(msg);
        Message inMessage = (Message) com.readObject();
        if ( inMessage.getType() != MessageType.STATUS_OK ){
            GenericIO.writelnString("payForTheService - Manager thread was interrupted.");
            System.exit(1);                     
        }            
        
        com.close();    
    
    }

}
