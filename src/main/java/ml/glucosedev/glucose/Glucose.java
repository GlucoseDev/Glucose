package ml.glucosedev.glucose;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Glucose {
    static Logger j = LogManager.getLogger();
    public static String getImplName(){
    return "Glucose";
    }
//    public static void main(String args[]) throws IOException {
//        j.info("Starting Glucose...");
//        if (args[0].equalsIgnoreCase("raw")) {
//            new GlucoseEventHandler().serverInitializeEvent();
//            new GlucoseEventHandler().serverStartEvent();
//            j.info("Done");
//        }
//    }
    public static String contributors = "Tedster, ServL";
    public static String lead = "SlimeDiamond";
}
