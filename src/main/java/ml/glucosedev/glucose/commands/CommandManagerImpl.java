package ml.glucosedev.glucose.commands;

import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandManager;
import org.jetbrains.annotations.NotNull;

public class CommandManagerImpl implements CommandManager {

    public CommandManagerImpl() {
        // TODO: Server implementation
    }

    @NotNull
    @Override
    public void registerCommand(@NotNull Command command) {
        String[] alias = command.aliases();
        for (String cmd : command.aliases()) {
            // TODO: Register command aliases
        }
    }

    @Override
    public void unregisterAllCommands() {
        // TODO
    }
}
