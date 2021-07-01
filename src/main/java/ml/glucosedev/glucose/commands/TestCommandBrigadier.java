//package ml.glucosedev.glucose.commands;
//
//import com.mojang.brigadier.CommandDispatcher;
//import com.mojang.brigadier.builder.LiteralArgumentBuilder;
//import net.minecraft.commands.CommandSource;
//import net.minecraft.commands.CommandSourceStack;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
//
//public class TestCommandBrigadier {
//    static Logger j = LogManager.getLogger();
//    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
//        dispatcher.register(LiteralArgumentBuilder.literal("glucosetest")
//                .executes(context -> {
//                    j.info(context.getSource());
//                    return 1;
//        }));
//    }
//
//}
