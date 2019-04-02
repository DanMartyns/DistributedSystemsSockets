/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Interfaces.ManagerRepairArea;

/**
 *
 * @author danielmartins
 */
public class RepairArea implements ManagerRepairArea {

    private final String server;
    private final int port;
    
    public RepairArea (String server, int port) {
        this.server = server;
        this.port = port;
    }    
    
    public void registerService(int customer){
        
    }
    
    /**
     * Replace the pieces (RepairArea)
     */
    public void storePart(String peca, int quantidade){
        
    }
    
    /**
     * Role responsible for telling mechanics that work is over (RepairArea)
     */
    public void shutdownNow(){
        
    }
}
