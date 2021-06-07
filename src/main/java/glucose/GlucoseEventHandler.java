package glucose;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/* Ty Mojang.. */
public class GlucoseEventHandler {
    private static final Logger LOGGER = LogManager.getLogger();
    public void serverStartEvent(){
        /* Load plugins */
        final File PLUGIN_DIR = new File(System.getProperty("java.io.tmpdir"));
        File plugDir = new File(PLUGIN_DIR, "new_directory");
        if (plugDir.exists()) {
            /* Ignore */
        } else {
            /* Create plugins directory if it doesn't exist */
            LOGGER.info("Plugins directory does not exist, creating...");
            try {
                plugDir.mkdir();
            } catch(IOException e) {
                LOGGER.info("Could not create plugins directory! Stack trace:");
                e.printStackTrace();
            }
        }
        /* Coming soon to a town near you... */
    }
}
