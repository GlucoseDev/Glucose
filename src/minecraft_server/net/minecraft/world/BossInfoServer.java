package net.minecraft.world;

import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class BossInfoServer extends BossInfo
{
    private final Set<EntityPlayerMP> players = Sets.<EntityPlayerMP>newHashSet();
    private final Set<EntityPlayerMP> readOnlyPlayers;
    private boolean visible;

    public BossInfoServer(ITextComponent nameIn, BossInfo.Color colorIn, BossInfo.Overlay overlayIn)
    {
        super(MathHelper.getRandomUUID(), nameIn, colorIn, overlayIn);
        this.readOnlyPlayers = Collections.<EntityPlayerMP>unmodifiableSet(this.players);
        this.visible = true;
    }

    public void setPercent(float percentIn)
    {
        if (percentIn != this.percent)
        {
            super.setPercent(percentIn);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PCT);
        }
    }

    public BossInfo setDarkenSky(boolean darkenSkyIn)
    {
        if (darkenSkyIn != this.darkenSky)
        {
            super.setDarkenSky(darkenSkyIn);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }

        return this;
    }

    public BossInfo setPlayEndBossMusic(boolean playEndBossMusicIn)
    {
        if (playEndBossMusicIn != this.playEndBossMusic)
        {
            super.setPlayEndBossMusic(playEndBossMusicIn);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }

        return this;
    }

    public BossInfo setCreateFog(boolean createFogIn)
    {
        if (createFogIn != this.createFog)
        {
            super.setCreateFog(createFogIn);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }

        return this;
    }

    public void func_186739_a(ITextComponent p_186739_1_)
    {
        if (!Objects.equal(p_186739_1_, this.name))
        {
            super.func_186739_a(p_186739_1_);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_NAME);
        }
    }

    private void sendUpdate(SPacketUpdateBossInfo.Operation operationIn)
    {
        if (this.visible)
        {
            SPacketUpdateBossInfo spacketupdatebossinfo = new SPacketUpdateBossInfo(operationIn, this);

            for (EntityPlayerMP entityplayermp : this.players)
            {
                entityplayermp.connection.sendPacket(spacketupdatebossinfo);
            }
        }
    }

    /**
     * Makes the boss visible to the given player.
     */
    public void addPlayer(EntityPlayerMP player)
    {
        if (this.players.add(player) && this.visible)
        {
            player.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.ADD, this));
        }
    }

    /**
     * Makes the boss non-visible to the given player.
     */
    public void removePlayer(EntityPlayerMP player)
    {
        if (this.players.remove(player) && this.visible)
        {
            player.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.REMOVE, this));
        }
    }

    public void setVisible(boolean visibleIn)
    {
        if (visibleIn != this.visible)
        {
            this.visible = visibleIn;

            for (EntityPlayerMP entityplayermp : this.players)
            {
                entityplayermp.connection.sendPacket(new SPacketUpdateBossInfo(visibleIn ? SPacketUpdateBossInfo.Operation.ADD : SPacketUpdateBossInfo.Operation.REMOVE, this));
            }
        }
    }

    public Collection<EntityPlayerMP> getPlayers()
    {
        return this.readOnlyPlayers;
    }
}
