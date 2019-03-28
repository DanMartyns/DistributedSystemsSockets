
package MainPackage;

import static MainPackage.Constants.*;

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
        // TODO
        // Example : GeneralInformationRepo logger = new GeneralInformationRepo(Constants.LOGGER_HOST_NAME, Constants.LOGGER_PORT);
        
        /**
         * Broker lifecycle start.
         */
        Manager manager = new Manager(0, lounge,  supplierSite, repairArea,outsideWorld, logger); --> Initialize stubs of each one 
        manager.start();
        try {
            manager.join();
        } catch (InterruptedException ex) {
        }
    }
    
    
}
