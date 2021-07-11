package ml.glucosedev.glucose.commands;

import ml.glucosedev.glucoselib.command.CommandCaller;

public interface NativeCommand {
    void execute(CommandCaller caller, String[] parameters);
    // Classify command as native
}
