/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Interfaces.ManagerOutsideWorld;

/**
 *
 * @author danielmartins
 */
public class OutsideWorld implements ManagerOutsideWorld {

    private final String server;
    private final int port;
    
    public OutsideWorld(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    public void phoneCustomer(String id){
        
    }  
}
