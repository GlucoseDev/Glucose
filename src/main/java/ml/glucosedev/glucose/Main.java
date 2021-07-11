package ml.glucosedev.glucose;

//import jdk.internal.joptsimple.*;
import joptsimple.*;
import net.minecraft.SharedConstants;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class Main {
    static Logger j = LogManager.getLogger();
    public static void main(@NotNull final String[] args) {
        j.info("------------------------------");
        j.info("Glucose");
        j.info("https://github.com/GlucoseDev/Glucose");
        j.info("Loads of code stolen from Loom... Check them out! > https://github.com/LoomDev/Loom/");
        j.info("------------------------------");

        new GlucoseEventHandler().beforeStartEvent();
            j.info("Starting Minecraft Server..."); //sdfoisdujfosdjfsdofsd
            if (!(SharedConstants.getCurrentVersion().getName().startsWith("1.17") && ManagementFactory.getRuntimeMXBean().getVmVersion().equals("1.16"))) {
                j.error("You are not running on Java 16, as of Minecraft 1.17, Java 16 is required.");
                j.info("Download Java 16 here: https://www.oracle.com/java/technologies/javase-downloads.html#JDK16");
                System.exit(0);
            }
            net.minecraft.server.Main.main(args); // Start native Minecraft server
    }
}
