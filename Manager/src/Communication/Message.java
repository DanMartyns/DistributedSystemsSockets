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
     * Serial version of the class. Format used is XXYYZZ (classNumber-praticClassNumber-groupNumber)
     */
    private final long serialVersionUID = 010401L;
    
    private MessageType type;
    
    private ManagerState state;
    
    public Message(){
        type = null;
        state = null;
    }
    
    public Message(MessageType type){
        this();
        this.type = type;
    }
    
    public Message(MessageType type, int choice){
        this();
        this.type = type;
        
//        switch(type){
//            case  
//        }
                
    }
}
