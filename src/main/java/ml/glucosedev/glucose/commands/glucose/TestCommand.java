package ml.glucosedev.glucose.commands.glucose;

import ml.glucosedev.glucoselib.command.Command;
import ml.glucosedev.glucoselib.command.CommandCaller;

public class TestCommand {
    String testString = "Element";
    @Command(
            name = "test",
            aliases = {"test"},
            description = "A Glucose test command",
            permission = "glucose.test"
    )
    public void testCommand(CommandCaller caller) {
        caller.send("Hello! {}", testString); // Should replace {} like log4j
    }
}
