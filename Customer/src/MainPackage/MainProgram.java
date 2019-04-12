
package MainPackage;

import static MainPackage.Constants.*;
import Stubs.Lounge;
import Stubs.OutsideWorld;
import Stubs.Park;

/**
 * Main manager program.
 * Initialize stubs and start manager lifecycle.
 * @author Daniel Martins
 */
public class MainProgram {
    
    public static void main(String [] args){
        
        /**
         * Stub initialization.
         */
        Lounge lounge = new Lounge( Constants.LOUNGE_HOST_NAME,Constants.LOUNGE_PORT );
<<<<<<< HEAD
=======

>>>>>>> de47baa29e1030af050f241539cb9a20afa32692
        OutsideWorld outsideWorld = new OutsideWorld ( Constants.OUTSIDEWORLD_HOST_NAME, Constants.OUTSIDEWORLD_PORT );
        Park park = new Park(Constants.PARK_HOST_NAME, Constants.PARK_PORT);
        /**
         * Manager lifecycle start.
         */
        
        Customer[] customer = new Customer[NUM_CUSTOMERS];
 

        for(int i = 0; i<NUM_CUSTOMERS; i++){
            customer[i] = new Customer(i, outsideWorld, i,  park,  lounge);
            customer[i].start();
        }
        
        
        for (int i = 0; i<NUM_CUSTOMERS; i++) {
            try{
                customer[i].join();
            }
            catch(InterruptedException e){}
        }
    }
    
    
}
