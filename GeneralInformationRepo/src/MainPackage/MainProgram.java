package MainPackage;

import java.net.SocketTimeoutException;
import Communication.ServerComm;
import Locations.GeneralInformationRepo;
import Locations.GeneralInformationRepoProxy;
import Locations.ServiceProvider;
import static MainPackage.Constants.FILE_NAME;

/**
 * Main Logger program.
 * Initializes the service provider and waits for a connection
 * in a communication channel.
 * @author Daniel Martins
 */
public class MainProgram {
    
    /**
     * Used to check if the service must terminate.
     */
    public static boolean serviceEnd = false;
    
    /**
     * Main control center launcher
     * @param args args
     */
    public static void main(String[] args) {
        /**
         * Communication channels.
         */
        ServerComm scon, sconi;
        ServiceProvider sp;        
        
        
        GeneralInformationRepo logger = new GeneralInformationRepo(FILE_NAME);
        
        logger.initStateLog();
        logger.printHeaderLog();  
        
        GeneralInformationRepoProxy loggerInt = new GeneralInformationRepoProxy(logger);
        
        /**
         * Start listening on the communication channel.
         */
        scon = new ServerComm(Constants.LOGGER_PORT);
        scon.start();
        
        /**
         * While the service is not terminated, accept connections and send them
         * to the service provider.
         */
        while(!serviceEnd){
            try {
                sconi = scon.accept();
                sp = new ServiceProvider(sconi, loggerInt);
                sp.start();
            } catch (SocketTimeoutException ex) {
            }
            
        }
    }
    
}
