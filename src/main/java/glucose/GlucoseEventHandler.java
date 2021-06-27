package glucose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/* Ty Mojang.. */
public class GlucoseEventHandler {
    static Logger j = LogManager.getLogger();
    public void serverStartEvent(){
        /* Load plugins */
        final File PLUGIN_DIR = new File(System.getProperty("java.io.tmpdir"));
        File plugDir = new File(PLUGIN_DIR, "new_directory");
        if (plugDir.exists()) {
            /* Ignore */
        } else {
            /* Create plugins directory if it doesn't exist */
            j.info("Plugins directory does not exist, creating...");
            plugDir.mkdir();
        }
        /* Coming soon to a town near you... */
    }
    public void serverInitializeEvent() throws IOException {
        new GlucoseConfig();
    }
}
