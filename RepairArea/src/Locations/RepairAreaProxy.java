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
public class RepairAreaProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final RepairArea l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public RepairAreaProxy(RepairArea l){
        this.l = l;
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
            case REGISTER_SERVICE:
                l.registerService(inMessage.getClient(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case STORE_PART : 
                l.storePart(inMessage.getClient(), inMessage.getQuantity(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SHUTDOWN :
                l.shutdownNow(inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case READ_THE_PAPER :
                String service = l.readThePaper(inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message (MessageType.RETURN_READ_THE_PAPER, service);
                break;
            
        }
        return outMessage;
    }    
}
