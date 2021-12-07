package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucose.plugin.GlucosePluginManager;
import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import ml.glucosedev.glucoselib.command.CommandExecutor;
import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.NotNull;

public class PluginsCommand implements CommandExecutor {
    @Override
    public void execute(@NotNull CommandContext commandContext) {
        CommandCaller caller = commandContext.getCaller();

        caller.send(ChatFormatting.DARK_GREEN + "Loaded Plugins: " + ChatFormatting.RESET + GlucosePluginManager.getPluginNames());
    }
}
