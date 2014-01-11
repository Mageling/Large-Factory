package nb.largefactory.util.errors;

public enum ConfigurationErrors {

    GENERAL_FAIL(""),
    ID_FAIL("");

    private String error;

    private ConfigurationErrors(String error) {
        this.error = error;
    }

}
