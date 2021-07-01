package ml.glucosedev.glucose;

import net.minecraft.server.MinecraftServer;

public class ServerImpl {
    private final MinecraftServer minecraftServer;

    public ServerImpl(MinecraftServer minecraftServer) {
        this.minecraftServer = minecraftServer;
    }

    public MinecraftServer getMinecraftServer() {
        return minecraftServer;
    }
}
