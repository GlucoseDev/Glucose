package ml.glucosedev.glucose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class GlucoseConfig {
    static Logger j = LogManager.getLogger("Glucose");
    public static Properties glucoseProp;
    public GlucoseConfig() throws  IOException {
        File propFile = new File("config/glucose.cfg");
        if (!propFile.exists()) {
            j.info("Creating Glucose Properties file...");
            try (OutputStream output = new FileOutputStream("./config/glucose.cfg")) {
                glucoseProp = new Properties();

                glucoseProp.setProperty("join-message", "%player% &ejoined the game"); //TODO
                glucoseProp.setProperty("leave-message", "%player% &eleft the game");//TODO
                glucoseProp.setProperty("tnt-explodes", String.valueOf(true));//TODO
                glucoseProp.setProperty("unknown-command", "&cUnknown command... Use /help for help");//TODO
//                glucoseProp.setProperty("console-prompt", ">"); // TODO

                glucoseProp.store(output, "Glucose config file");
                j.info("Created properties file");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
