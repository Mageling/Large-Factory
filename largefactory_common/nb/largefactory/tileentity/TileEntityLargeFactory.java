package nb.largefactory.tileentity;

import nb.largefactory.lib.Strings;
import nb.largefactory.network.PacketTypeHandler;
import nb.largefactory.network.packet.PacketTileUpdate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityLargeFactory extends TileEntity {

    protected String customName;

    public TileEntityLargeFactory() {

        customName = "";
    }

    public boolean hasCustomName() {

        return customName != null && customName.length() > 0;
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return true;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Strings.NBT_TE_CUSTOM_NAME)) {
            customName = nbtTagCompound.getString(Strings.NBT_TE_CUSTOM_NAME);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        if (this.hasCustomName()) {
            nbtTagCompound.setString(Strings.NBT_TE_CUSTOM_NAME, customName);
        }
    }

    @Override
    public Packet getDescriptionPacket() {

        return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord,
                yCoord, zCoord, customName));
    }

}
