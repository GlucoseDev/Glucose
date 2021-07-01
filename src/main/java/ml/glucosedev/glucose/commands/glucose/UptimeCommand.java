package ml.glucosedev.glucose.commands.glucose;

import jdk.jfr.internal.JVM;
import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandCaller;
import net.minecraft.ChatFormatting;

import java.lang.management.ManagementFactory;

public class UptimeCommand {
    @Command(
            name = "uptime",
            aliases = {"uptime", "up"},
            description = "Get the server uptime",
            permission = "glucose.uptime"
    )
    public void uptimeCommand(CommandCaller caller) {
        caller.send(ChatFormatting.DARK_GREEN+"Server uptime: "+ChatFormatting.RESET+ ManagementFactory.getRuntimeMXBean().getUptime());
    }
}
