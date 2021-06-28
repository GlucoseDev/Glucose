package ml.glucosedev.glucose;

//import jdk.internal.joptsimple.*;
import joptsimple.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main {
    static Logger j = LogManager.getLogger();
    public static void main(@NotNull final String[] args) {
        j.info("------------------------------");
        j.info("Glucose");
        j.info("https://github.com/GlucoseDev/Glucose");
        j.info("Loads of code stolen from Loom... Check them out! > https://github.com/LoomDev/Loom/");
        j.info("------------------------------");

        new GlucoseEventHandler().beforeStartEvent();

        OptionParser parser = new OptionParser();
        OptionSpecBuilder var2 = parser.accepts("nogui");
        OptionSpecBuilder var3 = parser.accepts("initSettings", "Initializes 'server.properties' and 'eula.txt', then quits");
        OptionSpecBuilder var4 = parser.accepts("demo");
        OptionSpecBuilder var5 = parser.accepts("bonusChest");
        OptionSpecBuilder var6 = parser.accepts("forceUpgrade");
        OptionSpecBuilder var7 = parser.accepts("eraseCache");
        OptionSpecBuilder var8 = parser.accepts("safeMode", "Loads level with vanilla datapack only");
        AbstractOptionSpec var9 = parser.accepts("help").forHelp();
        ArgumentAcceptingOptionSpec var10 = parser.accepts("singleplayer").withRequiredArg();
        ArgumentAcceptingOptionSpec var11 = parser.accepts("universe").withRequiredArg().defaultsTo(".", new String[0]);
        ArgumentAcceptingOptionSpec var12 = parser.accepts("world").withRequiredArg();
        ArgumentAcceptingOptionSpec var13 = parser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(-1, new Integer[0]);
        ArgumentAcceptingOptionSpec var14 = parser.accepts("serverId").withRequiredArg();
        NonOptionArgumentSpec var15 = parser.nonOptions();

        try {
            OptionSet options = parser.parse(args);
            if (options.has(var9)) {
                parser.printHelpOn(System.err);
                return;
            }
            j.info("Starting Minecraft Server...");
            net.minecraft.server.Main.main(options); // Starts Native Minecraft server

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
