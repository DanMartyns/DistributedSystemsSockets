
package MainPackage;

import Stubs.Lounge;
import Stubs.OutsideWorld;
import Stubs.RepairArea;
import Stubs.SupplierSite;

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
        OutsideWorld outsideWorld = new OutsideWorld ( Constants.OUTSIDEWORLD_HOST_NAME, Constants.OUTSIDEWORLD_PORT );
        SupplierSite supplierSite = new SupplierSite ( Constants.SUPPLIERSITE_HOST_NAME, Constants.SUPPLIERSITE_PORT );        
        RepairArea repairArea = new RepairArea ( Constants.REPAIRAREA_HOST_NAME, Constants.REPAIRAREA_PORT );        
        
        /**
         * Manager lifecycle start.
         */
        Manager manager = new Manager(0, lounge,  supplierSite, repairArea,outsideWorld); 
        manager.start();
        try {
            manager.join();
        } catch (InterruptedException ex) {
        }
    }
    
    
}
