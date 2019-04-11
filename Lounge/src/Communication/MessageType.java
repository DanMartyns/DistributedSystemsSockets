/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 * 
 * @author danielmartins
 */
public enum MessageType {

    /**
     * When a shared region answers with an OK to a request made by an entity.
     */
    STATUS_OK,    
    
    /**
     *
     */
    GET_NEXT_TASK,
    /**
     * 
     */
    APRAISE_SIT,

    /**
     *
     */
    RETURN_APRAISE_SIT,
    
    TALK_TO_CUSTOMER,

    RECEIVE_PAYMENT,

    HAND_CAR_KEY,

    REGISTER_SERVICE,

    PHONE_CUSTOMER,

    STORE_PART,

    GO_TO_SUPPLIER,

    RETURN_GO_TO_SUPPLIER,
    
    SHUTDOWN, 
    
    SET_MANAGER_STATE,
    
    SET_CUSTOMER_STATE, 
    
    SET_SIZE_QUEUE, 
    
    SET_WAITING_CARS, 
    
    SET_MECHANIC_STATE, 
    
    SET_FLAG_A, 
    
    SET_FLAG_B, 
    
    SET_FLAG_C 
}
