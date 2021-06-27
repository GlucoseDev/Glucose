package ml.glucosedev.glucose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class GlucosePluginLoader {
    static Logger j = LogManager.getLogger();
    public GlucosePluginLoader() throws IOException {
        j.info("Loading plugins...");
        File pluginDir = new File("./plugins/");
        if (!pluginDir.exists()) {
            j.info("Plugins directory does not exist, creating...");
            pluginDir.mkdirs();
            // Loading will come soon
        }
    }
}
