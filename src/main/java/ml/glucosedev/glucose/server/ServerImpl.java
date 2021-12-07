package ml.glucosedev.glucose.server;

import ml.glucosedev.glucoselib.server.Server;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class ServerImpl implements Server {
    private final MinecraftServer minecraftServer;

    public ServerImpl(MinecraftServer minecraftServer) {
        this.minecraftServer = minecraftServer;
    }

    @Override
    public @NotNull String getMcVersion() {
        return minecraftServer.getServerVersion();
    }

    @Override
    public @NotNull MinecraftServer getMinecraftServer() {
        return minecraftServer;
    }
}
