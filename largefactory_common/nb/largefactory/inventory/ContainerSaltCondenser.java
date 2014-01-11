package nb.largefactory.inventory;

import nb.largefactory.tileentity.TileEntitySaltCondenser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSaltCondenser extends Container {

    public ContainerSaltCondenser(InventoryPlayer inventoryPlayer, TileEntitySaltCondenser saltCondenser) {

        // Add the output slot to the container
        addSlotToContainer(new SlotOutput(saltCondenser, TileEntitySaltCondenser.OUTPUT_INVENTORY_INDEX, 80, 36));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                addSlotToContainer(new Slot(inventoryPlayer, inventoryColumnIndex + inventoryRowIndex * 9 + 9,
                        8 + inventoryColumnIndex * 18, 84 + inventoryRowIndex * 18));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            addSlotToContainer(new Slot(inventoryPlayer, actionBarSlotIndex, 8 + actionBarSlotIndex * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

        ItemStack itemStack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack()) {

            ItemStack slotItemStack = slot.getStack();
            itemStack = slotItemStack.copy();

            /**
             * If we are shift-clicking an item out of the Salt Condenser's
             * container, attempt to put it in the first available slot in the
             * player's inventory
             */
            if (slotIndex < TileEntitySaltCondenser.INVENTORY_SIZE) {

                if (!mergeItemStack(slotItemStack, TileEntitySaltCondenser.INVENTORY_SIZE, inventorySlots.size(), false))
                    return null;
            }

            if (slotItemStack.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

        }

        return itemStack;
    }
}
