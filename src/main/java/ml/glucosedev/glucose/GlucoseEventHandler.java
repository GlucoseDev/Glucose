package ml.glucosedev.glucose;

import ml.glucosedev.glucose.plugin.GlucosePluginLoader;
import ml.glucosedev.glucoselib.event.Event;
import ml.glucosedev.glucoselib.event.EventManager;
import ml.glucosedev.glucoselib.event.PlayerJoinEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class GlucoseEventHandler {
    static Logger j = LogManager.getLogger("Glucose");
    private EventManager EventManager;

    public void serverStartEvent() throws IOException {
        new GlucosePluginLoader();
//        getEventHandler().registerEvent();
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
    public void playerJoin(PlayerJoinEvent event) {
        // TODO custom join messages
        // TODO MOTD
    }
    private GlucoseEventHandler getInstance() {
        return this;
    }
    private EventManager getEventHandler() {
        return EventManager;
    }
}
