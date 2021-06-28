package ml.glucosedev.glucose.commands;

import ml.glucosedev.glucose.util.TextTransformer;
import net.kyori.adventure.text.Component;
import net.minecraft.Util;
import net.minecraft.commands.CommandSource;

import java.util.UUID;

public class CommandSourceImpl {
    private final net.minecraft.commands.CommandSource mcSource;

    public CommandSourceImpl(CommandSource mcSource) {
        this.mcSource = mcSource;
    }
    public void send(String msg) {
        send(Component.text(msg));
    }
    public void send(Component msg) {
        send(msg, Util.NIL_UUID);
    }
    public void send(String msg, UUID sender) {
        send(Component.text(msg), sender);
    }
    public void send(Component msg, UUID sender) {
        mcSource.sendMessage(TextTransformer.toMinecraft(msg), sender);
    }
}
