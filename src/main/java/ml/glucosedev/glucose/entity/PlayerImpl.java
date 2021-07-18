package ml.glucosedev.glucose.entity;

import ml.glucosedev.glucose.util.TextTransformer;
import ml.glucosedev.glucoselib.entity.Player;
import net.kyori.adventure.text.Component;
import net.minecraft.Util;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

public class PlayerImpl implements Player {
    private final ServerPlayer player;
    public PlayerImpl(ServerPlayer player) {
        this.player = player;
    }

    @Override
    public String getName() {
        return player.getDisplayName().toString();
    }

    @Override
    public String getUUID() {
        return player.getUUID().toString();
    }

    public void send(String msg) {
        player.sendMessage(TextTransformer.toMinecraft(Component.text(msg)), Util.NIL_UUID);
    }
}
