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
public class LoungeProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final Lounge l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public LoungeProxy(Lounge l){
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
            case GET_NEXT_TASK :
                l.getNextTask(inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case APRAISE_SIT :
                String choice = l.appraiseSit();
                outMessage = new Message (MessageType.RETURN_APRAISE_SIT, choice);
                break;
            case TALK_TO_CUSTOMER:
                l.talkToCustomer(inMessage.getClient(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case RECEIVE_PAYMENT:
                l.receivePayment(inMessage.getClient());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case HAND_CAR_KEY:
                l.handCarKey(inMessage.getClient());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
        }
        return outMessage;
    }    
}
