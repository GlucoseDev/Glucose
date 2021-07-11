package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandCaller;
import ml.glucosedev.glucoselib.command.CommandContext;
import ml.glucosedev.glucoselib.command.CommandExecutor;

public class TestCommand implements CommandExecutor {
    String testString = "Element";
    @Command(
            name = "test",
            aliases = {"test"},
            description = "A Glucose test command",
            permission = "glucose.test",
            usage = "/test"
    )
    public void execute(CommandContext context) {
        CommandCaller caller = context.getCaller();
        caller.send("Hello!");
    }
}
