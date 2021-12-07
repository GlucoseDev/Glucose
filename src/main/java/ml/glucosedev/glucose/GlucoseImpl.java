package ml.glucosedev.glucose;

import ml.glucosedev.glucoselib.Glucose;
import ml.glucosedev.glucoselib.command.CommandManager;
import ml.glucosedev.glucoselib.event.EventManager;
import ml.glucosedev.glucoselib.server.Server;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class GlucoseImpl implements Glucose {
    private Server server;
    private CommandManager commandManager;
    private Logger logger;

    @Override
    public EventManager getEventManager() {
        return null;
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public ml.glucosedev.glucoselib.logging.Logger getLogger() {
//        return logger;
        return null; // TEMP
    }

    @Override
    public @NotNull String glucoseVersion() {
        return ml.glucosedev.glucose.Glucose.getImplName();
    }
}
