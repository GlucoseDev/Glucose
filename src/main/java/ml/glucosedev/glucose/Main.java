package ml.glucosedev.glucose;

//import jdk.internal.joptsimple.*;
import joptsimple.*;
import net.minecraft.SharedConstants;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static Logger j = LogManager.getLogger("Glucose");
    public static void main(@NotNull final String[] args) throws IOException {
        j.info("------------------------------");
        j.info("Glucose");
        j.info("https://github.com/GlucoseDev/Glucose");
        j.info("Loads of code stolen from Loom... Check them out! > https://github.com/LoomDev/Loom/");
        j.info("------------------------------");

        new GlucoseEventHandler().beforeStartEvent();
            File config = new File("config/");
            if (!config.exists()) {
                j.info("Creating config directory");
                config.mkdirs();
            }
            new GlucoseEventHandler().serverInitializeEvent(); // Glucose
            j.info("Starting Minecraft Server..."); //sdfoisdujfosdjfsdofsd
            if (!(ManagementFactory.getRuntimeMXBean().getVmVersion().startsWith("16"))) {
//                j.info("Java version: "+ManagementFactory.getRuntimeMXBean().getVmVersion());
                j.fatal("As of Minecraft 1.17.1, Java 16 is required. Please use Java 16.");
//                j.info("");
                System.exit(0);
            }

            File defaultProperties = new File("server.properties");
            File bannedIps = new File("banned-ips.json");
            File bannedPlayers = new File("banned-players.json");
            File ops = new File("ops.json");
            File whitelist = new File("whitelist.json");

            if (defaultProperties.exists()) {
                j.warn("Moving server.properties to config/server.cfg");
                j.warn("If you ever want to change from Glucose, please move this file to ./server.properties manually.");
                boolean moved = defaultProperties.renameTo(new File("config/server.cfg"));
                if (!moved) {
                    j.fatal("Could not move server.properties, please do this manually");
                    j.info("Using default configuration file");
                }
            }
            if (bannedIps.exists()) { bannedIps.renameTo(new File("config/banned-ips.json")); }
            if (bannedPlayers.exists()) { bannedPlayers.renameTo(new File("config/banned-players.json")); }
            if (ops.exists()) { ops.renameTo(new File("config/ops.json")); }
            if (whitelist.exists()) { whitelist.renameTo(new File("config/whitelist.json")); }
            net.minecraft.server.Main.main(args); // Start native Minecraft server
    }
}