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
            /**
             * Functions called by Customer
             */
            case DECIDE_ON_REPAIR :
                boolean decide = out.decideOnRepair(inMessage.getCustomerID(), inMessage.getState());
                outMessage = new Message(MessageType.RETURN_DECIDE_ON_REPAIR, decide);
                break;
            case BACK_TO_WORK_BY_BUS :
                out.backToWorkByBus(inMessage.getCustomerID(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case BACK_TO_WORK_BY_CAR :
                out.backToWorkByCar(inMessage.getInfoCustomer(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Manager
             */
             case PHONE_CUSTOMER :
                out.phoneCustomer(inMessage.getInfoCustomer(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
                                                                         
        }
        return outMessage;
    }    
}