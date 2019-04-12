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
public class ParkProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final Park l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public ParkProxy(Park l){
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
            /**
             * Functions called by Customer
             */
            case GO_TO_REPAIR_SHOP :
                l.goToRepairShop(inMessage.getInfoCustomer(), inMessage.getState());
                outMessage = new Message (MessageType.STATUS_OK);
                break;
            case FIND_CAR :
                int replacementCar = l.findCar(inMessage.getCustomerID(), inMessage.getState());
                outMessage = new Message (MessageType.RETURN_FIND_CAR, replacementCar);
                break;
            case COLLECT_CAR :
                l.collectCar(inMessage.getCustomerID(), inMessage.getState());
                outMessage = new Message (MessageType.STATUS_OK);
                break;
            /**
             * Function called by Mechanic
             */
            case RETURN_VEHICLE :
                l.returnVehicle(inMessage.getCustomerID());
                outMessage = new Message (MessageType.STATUS_OK);
                break;                                    
            case GET_VEHICLE :
                l.getVehicle(inMessage.getCustomerID()); 
                outMessage = new Message (MessageType.STATUS_OK);
                break;
            case BLOCK_VEHICLE :
                l.blockVehicle(inMessage.getCustomerID()); 
                outMessage = new Message (MessageType.STATUS_OK);
                break;   
            }

        return outMessage;
    }    
}
