package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucose.Glucose;
import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;

public class GlucoseCommand {
    @Command(
            name = "Glucose main command",
            aliases = {"glucose"},
            description = "Glucose command",
            permission = "glucose.glucose"
    )
    public void glucoseCommand(CommandCaller caller) {
        //CommandCaller caller = CommandContext.getCaller();
        caller.send(ChatFormatting.DARK_GREEN+"--- Glucose ---");
        caller.send(ChatFormatting.DARK_GREEN+"Lead developers: "+ChatFormatting.RESET+ Glucose.lead);
        caller.send(ChatFormatting.DARK_GREEN+"Contributors: "+ChatFormatting.RESET+ Glucose.contributors);
        caller.send(ChatFormatting.DARK_GREEN+"GitHub: "+ChatFormatting.RESET+"https://github.com/GlucoseDev/Glucose");
    }
}
