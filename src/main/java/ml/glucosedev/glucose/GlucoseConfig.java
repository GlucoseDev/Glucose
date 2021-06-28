package ml.glucosedev.glucose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class GlucoseConfig {
    static Logger j = LogManager.getLogger();
    public Properties glucoseProp;
    public GlucoseConfig() throws  IOException {
        File propFile = new File("glucose.properties");
        if (!propFile.exists()) {
            j.info("Creating Glucose Properties file...");
            try (OutputStream output = new FileOutputStream("./glucose.properties")) {
                glucoseProp = new Properties();

                glucoseProp.setProperty("joinMessage", "%player% &ejoined the game");
                glucoseProp.setProperty("leaveMessage", "%player% &eleft the game");
                glucoseProp.setProperty("tnt-explodes", String.valueOf(true));
                glucoseProp.setProperty("unknown-command", "&cUnknown command... Use /help for help");

                glucoseProp.store(output, "Will work very soon! :)");
                j.info("Created properties file");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
