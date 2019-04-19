/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author danielmartins
 */
public interface CustomerPark {
    
    /**
     * Customer collects the car that is already done
     * (Class Park)
     * @param myCar customer's car id
     * @param customerState customer's state
     */
    void collectCar(int myCar, String customerState);
    
    
    /**
     * customer go to repair shop
     * (Class Park)
     * @param info customer's info
     * @param customerState customer's state
    */
    void goToRepairShop(String info, String customerState);
    
    /**
     * customer find the replecment car on park
     * (Class Park)
     * @param id customer's id
     * @param customerState customer's state    
    */
    int findCar(int id, String customerState);
}
