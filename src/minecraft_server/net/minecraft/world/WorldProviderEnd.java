package net.minecraft.world;

import javax.annotation.Nullable;
import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.end.DragonFightManager;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderEnd extends WorldProvider
{
    private DragonFightManager dragonFightManager;

    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void createBiomeProvider()
    {
        this.biomeProvider = new BiomeProviderSingle(Biomes.SKY);
        NBTTagCompound nbttagcompound = this.worldObj.getWorldInfo().getDimensionData(DimensionType.THE_END);
        this.dragonFightManager = this.worldObj instanceof WorldServer ? new DragonFightManager((WorldServer)this.worldObj, nbttagcompound.getCompoundTag("DragonFight")) : null;
    }

    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorEnd(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed(), this.getSpawnCoordinate());
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.0F;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(x, 0, z)).getMaterial().blocksMovement();
    }

    public BlockPos getSpawnCoordinate()
    {
        return new BlockPos(100, 50, 0);
    }

    public int getAverageGroundLevel()
    {
        return 50;
    }

    public DimensionType getDimensionType()
    {
        return DimensionType.THE_END;
    }

    /**
     * Called when the world is performing a save. Only used to save the state of the Dragon Boss fight in
     * WorldProviderEnd in Vanilla.
     */
    public void onWorldSave()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();

        if (this.dragonFightManager != null)
        {
            nbttagcompound.setTag("DragonFight", this.dragonFightManager.getCompound());
        }

        this.worldObj.getWorldInfo().setDimensionData(DimensionType.THE_END, nbttagcompound);
    }

    /**
     * Called when the world is updating entities. Only used in WorldProviderEnd to update the DragonFightManager in
     * Vanilla.
     */
    public void onWorldUpdateEntities()
    {
        if (this.dragonFightManager != null)
        {
            this.dragonFightManager.tick();
        }
    }

    @Nullable
    public DragonFightManager getDragonFightManager()
    {
        return this.dragonFightManager;
    }
}
