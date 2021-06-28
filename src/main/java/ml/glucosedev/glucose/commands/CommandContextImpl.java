package ml.glucosedev.glucose.commands;

import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CommandContextImpl implements CommandContext {
    public final CommandCaller caller;
    public final String[] alias;
    public final String[] args;

    public CommandContextImpl(CommandCaller caller, String[] alias, String[] args) {
        this.caller = caller;
        this.alias = alias;
        this.args = args;
    }
    @Override
    public CommandCaller getCaller() {
        return caller;
    }

    @Override
    public @NotNull String[] aliases() {
        return alias;
    }

    @Override
    public @Nullable String[] getArgs() {
        return getArgs();
    }
}
