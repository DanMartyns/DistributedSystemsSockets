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
public class GeneralInformationRepoProxy implements InterfaceLocation {
    /**
     * Lounge used to process the messages.
     */
    private final GeneralInformationRepo l;
    
    /**
     * Lounge Proxy constructor.
     * @param l betting center to process the messages
     */
    public GeneralInformationRepoProxy(GeneralInformationRepo l){
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
             * Funtion called by Lounge
             */
            case SET_MANAGER_STATE : //Function called by Lounge, RepairArea and Supplier Site
                l.setManagerState(inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_CUSTOMER_STATE :
                l.setCustomerState(inMessage.getCustomerID(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_SIZE_QUEUE :
                l.setValueQueueIn(inMessage.getQueueIn());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case SET_WAITING_CARS :
                l.setNumberWaitingReplece(inMessage.getWaits());
                outMessage = new Message(MessageType.STATUS_OK);
                break;    
            case SET_MECHANIC_STATE :
                l.setMechanicState(inMessage.getMechanicID(), inMessage.getState());
                outMessage = new Message(MessageType.STATUS_OK);
                break; 
            case SET_FLAG_A :
                l.setFlagAPieces(inMessage.getPiece());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_FLAG_B :
                l.setFlagBPieces(inMessage.getPiece());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_FLAG_C :
                l.setFlagCPieces(inMessage.getPiece());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Functions called by Outside World        
             */    
            case SET_REPLACEMENT_CAR :
                l.setReplecementCar(inMessage.getReplacementCar(), inMessage.getInfoCustomer());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                 
            /**
             * Functions called by Park        
             */
            case SET_ALREADY_REPAIRED :
                l.setAlreadyRepaired(inMessage.getCustomerID(), inMessage.getRepairedCars());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_OWN_CAR :
                l.setOwnCar(inMessage.getCustomerID(), inMessage.getInfoCustomer());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_WAIT_REPLACEMENT :
                l.setNumberWaitingReplece(inMessage.getWaits());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            /**
             * Function called by Repair Area
             */
            case SET_SERVICE:
                l.setNumberServiceRequest(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case SET_PIECE_AVAILABLE :
                l.setPiecesAvabal(inMessage.getPiece());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_A_STORED : 
                l.setPieces0Stored(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case PIECES_B_STORED : 
                l.setPieces1Stored(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_C_STORED : 
                l.setPieces2Stored(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_A_STORED_MANAGER :
                l.setPieces0Manager(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
            case PIECES_B_STORED_MANAGER :
                l.setPieces1Manager(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;
            case PIECES_C_STORED_MANAGER :
                l.setPieces2Manager(inMessage.getQuantity());
                outMessage = new Message(MessageType.STATUS_OK);
                break;                
        }
        return outMessage;
    }    
}