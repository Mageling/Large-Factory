package nb.largefactory.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(String configPath) {

        GeneralConfiguration.init(new File(configPath + "general.properties"));
        IDConfiguration.init(new File(configPath + "ids.properties"));

    }

}
