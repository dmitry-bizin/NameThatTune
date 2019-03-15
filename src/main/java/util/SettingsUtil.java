package util;

public class SettingsUtil {

    public static final String CURRENT_DIRECTORY_KEY = "currentDirectory";
    public static final String COUNT_SECONDS_KEY = "countSeconds";
    public static final String CURRENT_DIRECTORY_DEFAULT_VALUE = System.getProperty("user.home");
    public static final String COUNT_SECONDS_DEFAULT_VALUE = "30";

    private SettingsUtil() {
    }

}
