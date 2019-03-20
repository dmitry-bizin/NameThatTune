package util;

import dao.SettingsDAO;

import java.util.Optional;

public class SettingsUtil {

    public static final String CURRENT_DIRECTORY_KEY = "currentDirectory";
    public static final String COUNT_SECONDS_KEY = "countSeconds";
    public static final String CURRENT_DIRECTORY_DEFAULT_VALUE = System.getProperty("user.home");
    public static final String COUNT_SECONDS_DEFAULT_VALUE = "30";
    private static final SettingsDAO SETTINGS_DAO = new SettingsDAO();

    private SettingsUtil() {
    }

    public static Integer getCountSeconds() {
        return Integer.parseInt(Optional.ofNullable(SETTINGS_DAO.readByKey(COUNT_SECONDS_KEY))
                .orElse(COUNT_SECONDS_DEFAULT_VALUE));
    }

}
