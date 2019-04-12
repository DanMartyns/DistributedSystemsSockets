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
    private String clientInfo;

    /**
     * The information about the piece
     */
    private String piece;

    /**
     * The number of pieces who'll be stored
     */
    private int quantity;
    
    /**
     * The Customer ID
     */
    private int idCust;

    /**
     * The Mechanic ID
     */
    private int idMechan;    
    /**
     * The id of the car
     */
    private int carId;
    
    /**
     * Which service was chosen
     */
    private String readPaper;
    
    /**
     * The size of the queue
     */
    private int size_queue;
    
    /**
     * Number of customers waiting for a replacement car
     */
    private int waitReplacement;
    
    /**
     * Flag to signal missing part A
     */
    private String flag_A;
    
    /**
     * Flag to signal missing part B
     */
    private String flag_B;
    /**
     * Flag to signal missing part C
     */    
    private String flag_C;
    
    /**
     * Which service was registed
     */
    private int service;
    
    /**
     * Check if the piece is available
     */
    private String pieceAvailable;
    
    /**
     * Number of A-pieces
     */
    private int piecesA;

    /**
     * Number of B-pieces
     */     
    private int piecesB;
    
    /**
     * Number of C-pieces
     */    
    private int piecesC;
    
    /**
     * How many A-pieces the manager stored
     */
    private int manager_stored_pieceA;

    /**
     * How many B-pieces the manager stored
     */    
    private int manager_stored_pieceB;
    
    /**
     * How many C-pieces the manager stored
     */    
    private int manager_stored_pieceC;
    /**
     * Empty constructor for the message that initializes the default
     * values for all the variables.
     */    
    public Message(){
        type = null;   
        state = null;
        apraiseSit = null;
        clientInfo = null;
        piece = null;
        quantity = -1;
        idCust = -1;
        idMechan = -1;    
        carId = -1;
        readPaper = null;
        size_queue = -1;
        waitReplacement = -1;
        flag_A = null;
        flag_B = null;   
        flag_C = null;
        service = -1;
        pieceAvailable = null;
        piecesA = -1;   
        piecesB = -1;   
        piecesC = -1;
        manager_stored_pieceA = -1;   
        manager_stored_pieceB = -1; 
        manager_stored_pieceC = -1;
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
                this.clientInfo = value;
                break;
            case HAND_CAR_KEY:
                this.clientInfo = value; 
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
            case SET_PIECE_AVAILABLE :
                this.pieceAvailable = value;
                break;
            case RETURN_READ_THE_PAPER:
                this.readPaper = value;
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
            case RETURN_VEHICLE:
                this.carId = value;
                break;
            case GET_VEHICLE:
                this.carId = value;
                break;
            case TALK_WITH_MANAGER:
                this.idCust = value;
                break;
            case PAY_FOR_THE_SERVICE:
                this.idCust = value;
                break;
            case SET_SERVICE :
                this.service = value;
                break;
            case PIECES_A_STORED : 
                this.piecesA = value;
                break;
            case PIECES_B_STORED : 
                this.piecesB = value;                
                break;
            case PIECES_C_STORED : 
                this.piecesC = value;                
                break;
            case PIECES_A_STORED_MANAGER:
                this.manager_stored_pieceA = value;
                break;
            case PIECES_B_STORED_MANAGER:
                this.manager_stored_pieceB = value;
                break;
            case PIECES_C_STORED_MANAGER:
                this.manager_stored_pieceC = value;
                break;                
            case BLOCK_VEHICLE:
                this.carId = value;
                break;
            case CHECK_REQUEST:
                this.quantity = value;
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
                this.clientInfo = value;
                this.state = state;
                break;
            case REGISTER_SERVICE:
                this.clientInfo = value;
                this.state = state;
                break;
            case GO_TO_SUPPLIER:
                this.piece = value;
                this.state = state;
                break;
            case BACK_TO_WORK_BY_CAR:
                this.clientInfo = value;
                this.state = state;
                break;
            case QUEUE_IN:
                this.clientInfo = value;
                this.state = state;                                              
        }        
    }    

    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param value the id of the customer
     * @param state the customer state
     */
    public Message(MessageType type, int value, String state){
        this();
        this.type = type;
        switch(type){
            case SET_CUSTOMER_STATE :
                this.idCust = value;
                this.state = state;
                break;
            case SET_MECHANIC_STATE :
                this.idMechan = value;
                this.state = state;
                break;
            case DECIDE_ON_REPAIR:
                this.idCust = value;
                this.state = state;
                break;
            case BACK_TO_WORK_BY_BUS :
                this.idCust = value;
                this.state = state;
            case FIND_CAR :
                this.carId = value;
                this.state = state;
                break;
            case COLLECT_KEY:
                this.carId = value;
                this.state = state;
                break;    
            case READ_THE_PAPER:
                this.idMechan = value;
                this.state = state;
                break;        
        }        
    }    
    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param piece the piece who'll be stored
     * @param quantity the number of pieces who'll be stored
     * @param state the state of an entity
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
            case LET_MANAGER_KNOW:
                this.piece = piece;
                this.quantity = quantity;
                this.state = state;
                break;  
        }        
    }

    /**
     * Constructor with the type of the message and two String arguments.     
     * @param type type of the Message
     * @param currentCar the current car of the customer
     * @param quantity the number of pieces who'll be stored
     * @param state the state of an entity 
     */
    public Message(MessageType type, int currentCar, int quantity, String state){
        this();
        this.type = type;
        switch(type){
            case REPAIR_CONCLUDED:
                 this.carId = currentCar;
                 this.quantity = quantity;
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
        return clientInfo;
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

    /**
     * Get the customer ID
     * @return the id of the customer
     */
    public int getCustomerID() {
        return idCust;
    }

    /**
     * The size of the queue in the Lounge
     * @return the size of the queue
     */
    public int getSize_queue() {
        return size_queue;
    }

    /**
     * Get the number of cars waiting for a replacement car
     * @return the number of cars
     */
    public int getWaitReplacement() {
        return waitReplacement;
    }

    /**
     * Get the mechanic ID
     * @return the id of the mechanic
     */    
    public int getMechanicID() {
        return idMechan;
    }

    /**
     * Flag that says whether or not parts A are required
     * @return true or false
     */
    public String getFlag_A() {
        return flag_A;
    }

    /**
     * Flag that says whether or not parts B are required
     * @return true or false
     */    
    public String getFlag_B() {
        return flag_B;
    }

    /**
     * Flag that says whether or not parts C are required
     * @return true or false
     */    
    public String getFlag_C() {
        return flag_C;
    }

    /**
     * Get the car id of a customer
     * @return the car id
     */
    public int getCarId() {
        return carId;
    }

    /**
     * Get the service chosen
     * @return the service
     */
    public String getReadPaper() {
        return readPaper;
    }

    /**
     * Get the service registred
     * @return the service 
     */
    public int getService() {
        return service;
    }

    /**
     * Check if has pieces enough
     * @return the piece
     */
    public String getPieceAvailable() {
        return pieceAvailable;
    }

    /**
     * Number of pieces A
     * @return quantity
     */
    public int getPiecesA() {
        return piecesA;
    }

    /**
     * Number of pieces B
     * @return quantity
     */    
    public int getPiecesB() {
        return piecesB;
    }
    
    /**
     * Number of pieces C
     * @return quantity
     */    
    public int getPiecesC() {
        return piecesC;
    }

    /**
     * The amount of parts A that the manager will restore
     * @return the quantity
     */
    public int getManager_stored_pieceA() {
        return manager_stored_pieceA;
    }

    /**
     * The amount of parts B that the manager will restore
     * @return the quantity
     */    
    public int getManager_stored_pieceB() {
        return manager_stored_pieceB;
    }

    /**
     * The amount of parts C that the manager will restore
     * @return the quantity
     */    
    public int getManager_stored_pieceC() {
        return manager_stored_pieceC;
    }

}
