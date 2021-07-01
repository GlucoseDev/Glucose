//package ml.glucosedev.glucose.commands;
//
//import com.mojang.brigadier.CommandDispatcher;
//import com.mojang.brigadier.builder.LiteralArgumentBuilder;
//import com.mojang.brigadier.context.CommandContext;
//import ml.glucosedev.glucose.ServerImpl;
//import ml.glucosedev.glucoselib.command.Command;
//import ml.glucosedev.glucoselib.command.CommandCaller;
//import ml.glucosedev.glucoselib.command.CommandManager;
//import net.minecraft.commands.CommandSource;
//import net.minecraft.commands.CommandSourceStack;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Locale;
//import java.util.Map;
//import java.util.Optional;
//
//public class CommandManagerImpl implements CommandManager {
//    private final ServerImpl server; // yay!
//    private final CommandSourceStack commandSourceStack;
//    private final Map<String, Command> commands;
//    public CommandManagerImpl(ServerImpl server, CommandSourceStack commandSourceStack, Map<String, Command> commands) {
//        //registerCommand(new GlucoseCommand());
//        this.server = server;
//        this.commandSourceStack = commandSourceStack;
//        this.commands = commands;
//    }
//    @NotNull
//    private CommandDispatcher<CommandSourceStack> getDispatcher() {
//        return server.getMinecraftServer().getCommands().getDispatcher();
//    }
//
//    @NotNull
//    @Override
//    public void registerCommand(@NotNull Command command) {
//        String[] alias = command.aliases();
//        for (String cmd : command.aliases()) {
//            // TODO: Register command aliases
//        }
//    }
//
//    @Override
//    public void unregisterAllCommands() {
//        // TODO
//    }
//    @NotNull
//    private CommandCaller getCaller(@NotNull CommandSourceStack stack) {
//        CommandSource source = stack.source;
//        return (CommandCaller) new CommandSourceImpl(source);
//    }
//    private void registerInternal(@NotNull String alias, @NotNull Command command) {
//        getDispatcher().register(LiteralArgumentBuilder.literal(alias)
//        .requires(commandSourceStack -> {
//            CommandCaller caller = getCaller((CommandSourceStack) commandSourceStack);
//            return Optional.of("glucose.testpermission").map(caller::hasPermission).orELse(true);
//        }).executes(this::execute)
//        );
//    }
//
//    private int execute(CommandContext<Object> context) {
//        String[] args = context.getInput().split(" ");
//        if (args.length == 0) {
//            return 0;
//        }
//        String alias = args[0].toLowerCase(Locale.ROOT);
//        alias = alias.startsWith("/") ? alias.substring(1) : alias;
//        Command command = commands.get(alias);
//        if (command == null) {
//            return 0;
//        }
//        return 1;
//    }
//}
