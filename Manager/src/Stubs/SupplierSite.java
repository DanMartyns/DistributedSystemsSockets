/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import Interfaces.ManagerSupplierSite;

/**
 *
 * @author danielmartins
 */
public class SupplierSite implements ManagerSupplierSite {

    private final String server;
    private final int port;
    
    public SupplierSite(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    public int goToSupplier(String peca){
        return 0;
    }    
}
