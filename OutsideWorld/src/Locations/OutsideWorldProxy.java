/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locations;

import Communication.Message;
import Communication.MessageType;
import Communication.ServerComm;

/*
 * @author danielmartins
 */
public class OutsideWorldProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final OutsideWorld out;
    
    /**
     * OutsideWorld Proxy constructor.
     * @param out OutsideWorld to process the messages
     */
    public OutsideWorldProxy(OutsideWorld out){
        this.out = out;
    }
    
    /**
     * Process and reply a message.
     * @param inMessage message received
     * @param scon communication channel
     * @return message to be replied
     */
    @Override
    public Message processAndReply(Message inMessage, ServerComm scon){
        Message outMessage = null;
        
        switch(inMessage.getType()){
            
        }
        return outMessage;
    }    
}