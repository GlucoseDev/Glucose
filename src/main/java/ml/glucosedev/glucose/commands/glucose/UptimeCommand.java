package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import ml.glucosedev.glucoselib.command.CommandExecutor;
import net.minecraft.ChatFormatting;

import java.lang.management.ManagementFactory;

public class UptimeCommand implements CommandExecutor {
    @Command(
            name = "uptime",
            aliases = {"uptime", "up"},
            description = "Get the server uptime",
            permission = "glucose.uptime",
            usage = "/uptime"
    )
    public void execute(CommandContext context) {
        CommandCaller caller = context.getCaller();
        caller.send(ChatFormatting.DARK_GREEN+"Server uptime: "+ChatFormatting.RESET+ ManagementFactory.getRuntimeMXBean().getUptime());
    }
}
