package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import ml.glucosedev.glucoselib.command.CommandExecutor;
import net.minecraft.ChatFormatting;

import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.util.StringJoiner;

public class UptimeCommand implements CommandExecutor {
    public static String formatDuration(Duration d) {
        final long days = d.toDays();
        d = d.minusDays(days);
        final long hours = d.toHours();
        d = d.minusHours(hours);
        final long minutes = d.toMinutes();
        d = d.minusMinutes(minutes);
        final long seconds = d.getSeconds();
        final StringJoiner joiner = new StringJoiner(", ");
        if (days > 0) joiner.add(days + " days");
        if (hours > 0) joiner.add(hours + " hours");
        if (minutes > 0) joiner.add(minutes + " minutes");
        if (seconds > 0) joiner.add(seconds + " seconds");
        return joiner.toString();
    }
    public void execute(CommandContext context) {
        CommandCaller caller = context.getCaller();
        caller.send(ChatFormatting.DARK_GREEN+"Server uptime: "+ChatFormatting.RESET+ formatDuration(Duration.ofMillis(ManagementFactory.getRuntimeMXBean().getUptime())));
    }
}
