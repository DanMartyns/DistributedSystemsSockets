/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitiesState;

/**
 *
 * @author giselapinto
 */
public enum MechanicState {
    /**
    * WAITING FOR WORK.
    */
    WAITING_FOR_WORK ("WFW"),

   /**
    * FIXING THE CAR.
    */
   FIXING_CAR ("FIX"),

   /**
    * CHECKING THE STOCK.
    */
   CHECKING_STOCK ("CHS"),

   /**
    * ALEARTING THE STOCK.
    */
   ALERTING_MANAGER ("ALM");

   private final String description;

   private MechanicState(String description){
       this.description = description;
   }

   @Override
   public String toString(){
       return this.description;
   }     
}
