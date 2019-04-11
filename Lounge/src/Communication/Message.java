/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

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
     * The customer id
     */
    private int customerID;
    
    /**
     * The size of the queue
     */
    private int size_queue;
    private int waitReplacement;
    private String mechanicID;
    private String flag_A;
    private String flag_B;
    private String flag_C;

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
            case SET_MANAGER_STATE :
                this.state = value;
                break;
            case SET_FLAG_A :
                this.flag_A = value;
                break;
            case SET_FLAG_B :
                this.flag_B = value;
                break;
            case SET_FLAG_C :
                this.flag_C = value;
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
                break;
            case SET_SIZE_QUEUE:
                this.size_queue = value;
                break;
            case SET_WAITING_CARS:
                this.waitReplacement = value;
                break;
                
        }       
    }    

    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param value String argument
     * @param state state of the entity
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
     * @param id the id of the customer
     * @param state the customer state
     */
    public Message(MessageType type, int id, String state){
        this();
        this.type = type;
        switch(type){
            case SET_CUSTOMER_STATE :
                this.customerID = id;
                this.state = state;
                break;
            case SET_MECHANIC_STATE :
                this.mechanicID = state;
                this.state = state;
                break;
        }        
    }    

    /**
     * Get the type of the message
     * @return MessaType type of the Message
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Get the state of an entity
     * @return state of the entity
     */
    public String getState() {
        return state;
    }

    /**
     * Get service chosen
     * @return service chosen
     */
    public String getApraiseSit() {
        return apraiseSit;
    }

    /**
     * Get the information about customer
     * @return info about customer
     */
    public String getClient() {
        return client;
    }

    /**
     * Get the type of the piece
     * @return type of the piece
     */
    public String getPiece() {
        return piece;
    }

    /**
     * Get the quantity of one piece
     * @return quantity of the piece
     */
    public int getQuantity() {
        return quantity;
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getSize_queue() {
        return size_queue;
    }

    public int getWaitReplacement() {
        return waitReplacement;
    }

    public String getMechanicID() {
        return mechanicID;
    }

    public String getFlag_A() {
        return flag_A;
    }

    public String getFlag_B() {
        return flag_B;
    }

    public String getFlag_C() {
        return flag_C;
    }
}
