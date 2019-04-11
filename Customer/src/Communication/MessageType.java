/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 * 
 * @author giselapinto
 */
public enum MessageType {

    /**
     * When a shared region answers with an OK to a request made by an entity.
     */
    STATUS_OK,   
    
    
    /**
     * Manager get a next task
     */
    GET_NEXT_TASK,
    /**
     * Manager do a apraise situation
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

    /**
     *
     */
    PHONE_CUSTOMER,

    STORE_PART,

    GO_TO_SUPPLIER,

    RETURN_GO_TO_SUPPLIER,
    
    SHUTDOWN,
    
    /**
     *
     */
    DECIDE_ON_REPAIR,
    
    BACK_TO_WORK_BY_CAR,
    
    BACK_TO_WORK_BY_BUS,
    
    /**
     *
     */
    
    GO_TO_REPAIR_SHOP,
    
    FIND_CAR,
    COLLECT_CAR,
    RETURN_VEHICLE,
    GET_VEHICLE,
    
    QUEUE_IN,
    TALK_WITH_MANAGER,
    COLLECT_KEY,
    PAY_FOR_THE_SERVICE
    
}
