/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import EntitiesState.ManagerState;
import java.io.Serializable;

/**
 *
 * @author danielmartins
 */
public class Message implements Serializable {

    /**
     * Serial version of the class. Format used is XXYYZZ 
     * (classNumber-praticClassNumber-groupNumber)
     */
    private final long serialVersionUID = 010401L;

    /**
     * Type of the message.
     */    
    private MessageType type;

    /**
     * State of the Manager.
     */    
    private String state;

    /**
     * The service chosen in the shared region 'Lounge'
     */
    private String apraiseSit;

    /**
     * The information about client. 
     * The string is composed of (customerId,carId,currentCar,wantsCarOrNot,wantsPayOrNot)
     */
    private String client;

    /**
     * The information about the piece
     */
    private String piece;

    /**
     * The number of pieces who'll be stored
     */
    private int quantity;

    /**
     * Empty constructor for the message that initializes the default
     * values for all the variables.
     */    
    public Message(){
        type = null;
        state = null;
        apraiseSit = null;
        client = null;
    }
    
    /**
     * Constructor with only the type of the message.    
     * @param type type of the Message
     */
    public Message(MessageType type){
        this();
        this.type = type;
    }
    
    /**
     * Constructor with the type of the message and a String argument.    
     * @param type type of the Message
     * @param value String argument, the string can assume multiple definitions
     */
    public Message(MessageType type, String value){
        this();
        this.type = type;
        switch(type) {
            case GET_NEXT_TASK:
                this.state = value;
                break;
            case APRAISE_SIT :
            case RETURN_APRAISE_SIT :
                this.apraiseSit = value;
                break;
            case RECEIVE_PAYMENT:
                this.client = value;
                break;
            case HAND_CAR_KEY:
                this.client = value; 
                break;
            case SHUTDOWN : 
                this.state = value;
                break;   
        }       
    }
    /**
     * Constructor with the type of the message and an integer argument.    
     * @param type type of the Message
     * @param value Integer argument
     */
    public Message(MessageType type, int value){
        this();
        this.type = type;
        switch(type) {
            case RETURN_GO_TO_SUPPLIER:
                this.quantity = value;     
        }       
    }    

    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param value String argument
     * @param state state of the manager
     */
    public Message(MessageType type, String value, String state){
        this();
        this.type = type;
        switch(type){
            case TALK_TO_CUSTOMER :
                this.client = value;
                this.state = state;
                break;
            case REGISTER_SERVICE:
                this.client = value;
                this.state = state;
                break;
            case GO_TO_SUPPLIER:
                this.piece = value;
                this.state = state;
                break;                              
        }        
    }

    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param piece the piece who'll be stored
     * @param quantity the number of pieces who'll be stored
     */
    public Message(MessageType type, String piece, int quantity, String state){
        this();
        this.type = type;
        switch(type){
            case STORE_PART:
                this.piece = piece;
                this.quantity = quantity;
                this.state = state;
                break;       
        }        
    }    

    /**
     * Get the type of the message
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Get the state of an entity
     */
    public String getState() {
        return state;
    }

    /**
     * Get service chosen
     */
    public String getApraiseSit() {
        return apraiseSit;
    }

    /**
     * Get the information about customer
     */
    public String getClient() {
        return client;
    }

    /**
     * Get the type of the piece
     */
    public String getPiece() {
        return piece;
    }

    /**
     * Get the quantity of one piece
     */
    public int getQuantity() {
        return quantity;
    }
    
}
