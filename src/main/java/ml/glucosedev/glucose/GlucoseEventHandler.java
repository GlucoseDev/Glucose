package ml.glucosedev.glucose;

import ml.glucosedev.glucose.plugin.GlucosePluginLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class GlucoseEventHandler {
    static Logger j = LogManager.getLogger();
    public void serverStartEvent() throws IOException {
        new GlucosePluginLoader();
    }
    public void serverInitializeEvent() throws IOException {
        j.info("Initializing server...");
        new GlucoseConfig();
    }

    public void serverShutdownEvent() {
        j.info("Stopping Glucose...");
    }
    public void beforeStartEvent() {

    }

    public static void fireEvent() {

    }
}
