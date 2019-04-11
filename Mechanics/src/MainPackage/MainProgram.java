
package MainPackage;

import static MainPackage.Constants.*;
import Stubs.Lounge;
import Stubs.Park;
import Stubs.RepairArea;

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
        RepairArea repairArea = new RepairArea(Constants.REPAIRAREA_HOST_NAME, Constants.REPAIRAREA_PORT);
        Park park = new Park(Constants.PARK_HOST_NAME, Constants.PARK_PORT);
        /**
         * Manager lifecycle start.
         */
        
        Mechanic[] mechanic = new Mechanic[NUM_MECHANICS];
 

        for(int i = 0; i<NUM_MECHANICS; i++){

            mechanic[i] = new Mechanic(i, lounge, repairArea,  park);
            mechanic[i].start();
        }
        
        
        for (int i = 0; i<NUM_CUSTOMERS; i++) {
            try{
                mechanic[i].join();
            }
            catch(InterruptedException e){}
        }
    }
}
