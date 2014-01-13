package nb.largefactory.config;

import java.io.File;

import nb.largefactory.lib.Scalables;
import nb.largefactory.lib.Strings;
import nb.largefactory.util.logging.ConfigurationErrors;
import net.minecraftforge.common.Configuration;

public class GeneralConfiguration {

    public static void init(File configFile) {

        Configuration generalConfiguration = new Configuration(configFile);

        try {
            generalConfiguration.load();

            Scalables.TEA_GROWTH_FACTOR = generalConfiguration.get(Strings.CONFIG_GENERAL_CATEGORY,
                    Strings.CONFIG_TEA_GROWTH, Scalables.TEA_GROWTH_FACTOR_DEFAULT,
                    "Percentage of normal growth rate, default is 100").getInt(Scalables.TEA_GROWTH_FACTOR_DEFAULT);

        } catch (Exception e) {
            ConfigurationErrors.GENERAL_FAIL.printError(e);
        } finally {
            generalConfiguration.save();
        }

    }

}
