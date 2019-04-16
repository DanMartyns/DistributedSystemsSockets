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
    public Message processAndReply(Message inMessage){
        Message outMessage = null;
        
        switch(inMessage.getType()){
            /**
             * Functions called by Manager
             */            
            case REGISTER_SERVICE :
                l.registerService(inMessage.getInfoCustomer(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case STORE_PART : 
                l.storePart(inMessage.getPiece(), inMessage.getQuantity(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SHUTDOWN :
                l.shutdownNow(inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Mechanic
             */                  
            case READ_THE_PAPER :
                String service = l.readThePaper(inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message (MessageType.RETURN_READ_THE_PAPER, service);
                break;
            case START_REPAIR_PROCEDURE :
                l.startRepairProcedure(inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case FIX_IT :
                l.fixIt();
                outMessage = new Message(MessageType.STATUS_OK);
                break;                                        
            case GET_REQUIRED_PART :
                String piece = l.getRequiredPart(inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message (MessageType.RETURN_GET_REQUIRED_PART, piece);
                break;
            case PART_AVAILABLE :
                boolean available = l.partAvailable(inMessage.getPiece(), inMessage.getCustomerID());
                outMessage = new Message (MessageType.RETURN_PART_AVAILABLE, available);
                break;
            case RESUME_REPAIR_PROCEDURE :
                l.resumeRepairProcedure(inMessage.getPiece(), inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SERVICE_END :
                l.serviceEnd();
                outMessage = new Message(MessageType.STATUS_OK);
                break;                                      
        }
        return outMessage;
    }    
}
