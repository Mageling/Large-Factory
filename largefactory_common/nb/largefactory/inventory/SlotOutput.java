package nb.largefactory.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot {

    public SlotOutput(IInventory iInventory, int x, int y, int z) {
        super(iInventory, x, y, z);
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        return false;
    }

}
