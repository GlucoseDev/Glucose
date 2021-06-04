package net.minecraft.item;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRecord extends Item
{
    private static final Map<SoundEvent, ItemRecord> RECORDS = Maps.<SoundEvent, ItemRecord>newHashMap();
    private final SoundEvent sound;
    private final String displayName;

    protected ItemRecord(String p_i46742_1_, SoundEvent soundIn)
    {
        this.displayName = "item.record." + p_i46742_1_ + ".desc";
        this.sound = soundIn;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.MISC);
        RECORDS.put(this.sound, this);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer stack, World playerIn, BlockPos worldIn, EnumHand pos, EnumFacing hand, float facing, float hitX, float hitY)
    {
        IBlockState iblockstate = playerIn.getBlockState(worldIn);

        if (iblockstate.getBlock() == Blocks.JUKEBOX && !((Boolean)iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue())
        {
            if (!playerIn.isRemote)
            {
                ItemStack itemstack = stack.getHeldItem(pos);
                ((BlockJukebox)Blocks.JUKEBOX).insertRecord(playerIn, worldIn, iblockstate, itemstack);
                playerIn.playEvent((EntityPlayer)null, 1010, worldIn, Item.getIdFromItem(this));
                itemstack.func_190918_g(1);
                stack.addStat(StatList.RECORD_PLAYED);
            }

            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.PASS;
        }
    }

    /**
     * Return an item rarity from EnumRarity
     */
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}
