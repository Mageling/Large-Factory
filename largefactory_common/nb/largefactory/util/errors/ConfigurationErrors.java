package nb.largefactory.util.errors;

import java.util.logging.Level;

import nb.largefactory.lib.DefaultErrorLevels;
import nb.largefactory.lib.Reference;
import cpw.mods.fml.common.FMLLog;

public enum ConfigurationErrors {

    GENERAL_FAIL(""),
    ID_FAIL(Reference.MOD_NAME + "has had a problem loading its IDs configuration");

    private String error;

    private ConfigurationErrors(String error) {
        this.error = error;
    }

    public void printError() {
        printError((Exception) null);
    }

    public void printError(Level level) {
        printError(level, (Exception) null);

    }

    public void printError(Exception e) {
        printError(DefaultErrorLevels.CONFIGURATION, e);
    }

    public void printError(Level level, Exception e) {
        FMLLog.log(level, e, error);
    }

}
