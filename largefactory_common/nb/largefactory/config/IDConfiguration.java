package nb.largefactory.config;

import java.io.File;

import nb.largefactory.lib.BlockIDs;
import nb.largefactory.lib.ItemIDs;
import nb.largefactory.lib.Strings;
import nb.largefactory.util.errors.ConfigurationErrors;
import net.minecraftforge.common.Configuration;

public class IDConfiguration {

    public static void init(File configFile) {

        Configuration idConfiguration = new Configuration(configFile);

        try {

            idConfiguration.load();

            BlockIDs.SALT_BLOCK = idConfiguration.getBlock(Strings.SALT_BLOCK_NAME, BlockIDs.SALT_BLOCK_DEFAULT)
                    .getInt(BlockIDs.SALT_BLOCK_DEFAULT);
            BlockIDs.SALT_CONDENSER = idConfiguration.getBlock(Strings.SALT_CONDENSER_NAME,
                    BlockIDs.SALT_CONDENSER_DEFAULT).getInt(BlockIDs.SALT_CONDENSER_DEFAULT);
            BlockIDs.STRUCTURE_BLOCK = idConfiguration.getBlock(Strings.STRUCTURE_BLOCK_NAME,
                    BlockIDs.STRUCTURE_BLOCK_DEFAULT).getInt(BlockIDs.STRUCTURE_BLOCK_DEFAULT);
            BlockIDs.TEA_PLANT = idConfiguration.getBlock(Strings.TEA_PLANT_NAME, BlockIDs.TEA_PLANT_DEFAULT).getInt(
                    BlockIDs.TEA_PLANT_DEFAULT);

            ItemIDs.ITEM_STRUCTURE = idConfiguration.getItem(Strings.ITEM_STRUCTURE_NAME,
                    ItemIDs.ITEM_STRUCTURE_DEFAULT).getInt(ItemIDs.ITEM_STRUCTURE_DEFAULT);
            ItemIDs.SALT = idConfiguration.getItem(Strings.SALT_NAME, ItemIDs.SALT_DEFAULT)
                    .getInt(ItemIDs.SALT_DEFAULT);
            ItemIDs.SALT_PORK_COOKED = idConfiguration.getItem(Strings.SALT_PORK_COOKED_NAME,
                    ItemIDs.SALT_PORK_COOKED_DEFAULT).getInt(ItemIDs.SALT_PORK_COOKED_DEFAULT);
            ItemIDs.SALT_PORK_RAW = idConfiguration.getItem(Strings.SALT_PORK_RAW_NAME, ItemIDs.SALT_PORK_RAW_DEFAULT)
                    .getInt(ItemIDs.SALT_PORK_RAW_DEFAULT);
            ItemIDs.SALT_STEAK_COOKED = idConfiguration.getItem(Strings.SALT_STEAK_COOKED_NAME,
                    ItemIDs.SALT_STEAK_COOKED_DEFAULT).getInt(ItemIDs.SALT_STEAK_COOKED_DEFAULT);
            ItemIDs.SALT_STEAK_RAW = idConfiguration.getItem(Strings.SALT_STEAK_RAW_NAME,
                    ItemIDs.SALT_STEAK_RAW_DEFAULT).getInt(ItemIDs.SALT_STEAK_RAW_DEFAULT);
            ItemIDs.SALT_FISH_COOKED = idConfiguration.getItem(Strings.SALT_FISH_COOKED_NAME,
                    ItemIDs.SALT_FISH_COOKED_DEFAULT).getInt(ItemIDs.SALT_FISH_COOKED_DEFAULT);
            ItemIDs.SALT_FISH_RAW = idConfiguration.getItem(Strings.SALT_FISH_RAW_NAME, ItemIDs.SALT_FISH_RAW_DEFAULT)
                    .getInt(ItemIDs.SALT_FISH_RAW_DEFAULT);
            ItemIDs.SALT_CHICKEN_COOKED = idConfiguration.getItem(Strings.SALT_CHICKEN_COOKED_NAME,
                    ItemIDs.SALT_CHICKEN_COOKED_DEFAULT).getInt(ItemIDs.SALT_CHICKEN_COOKED_DEFAULT);
            ItemIDs.SALT_CHICKEN_RAW = idConfiguration.getItem(Strings.SALT_CHICKEN_RAW_NAME,
                    ItemIDs.SALT_CHICKEN_RAW_DEFAULT).getInt(ItemIDs.SALT_CHICKEN_RAW_DEFAULT);
            ItemIDs.SALT_CHUNK = idConfiguration.getItem(Strings.SALT_CHUNK_NAME, ItemIDs.SALT_CHUNK_DEFAULT).getInt(
                    ItemIDs.SALT_CHUNK_DEFAULT);
            ItemIDs.WHITE_TEA = idConfiguration.getItem(Strings.WHITE_TEA_NAME, ItemIDs.WHITE_TEA_DEFAULT).getInt(
                    ItemIDs.WHITE_TEA_DEFAULT);
            ItemIDs.GREEN_TEA = idConfiguration.getItem(Strings.GREEN_TEA_NAME, ItemIDs.GREEN_TEA_DEFAULT).getInt(
                    ItemIDs.GREEN_TEA_DEFAULT);
            ItemIDs.BLACK_TEA = idConfiguration.getItem(Strings.BLACK_TEA_NAME, ItemIDs.BLACK_TEA_DEFAULT).getInt(
                    ItemIDs.BLACK_TEA_DEFAULT);
            ItemIDs.WHITE_TEA_BASKET = idConfiguration.getItem(Strings.WHITE_TEA_BASKET_NAME,
                    ItemIDs.WHITE_TEA_BASKET_DEFAULT).getInt(ItemIDs.WHITE_TEA_BASKET_DEFAULT);
            ItemIDs.GREEN_TEA_BASKET = idConfiguration.getItem(Strings.GREEN_TEA_BASKET_NAME,
                    ItemIDs.GREEN_TEA_BASKET_DEFAULT).getInt(ItemIDs.GREEN_TEA_BASKET_DEFAULT);
            ItemIDs.BLACK_TEA_BASKET = idConfiguration.getItem(Strings.BLACK_TEA_BASKET_NAME,
                    ItemIDs.BLACK_TEA_BASKET_DEFAULT).getInt(ItemIDs.BLACK_TEA_BASKET_DEFAULT);

        } catch (Exception e) {

            ConfigurationErrors.ID_FAIL.printError(e);

        } finally {

            idConfiguration.save();

        }
    }

}
