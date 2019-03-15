package db;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;
import util.SettingsUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JDBC {

    private static final String INIT_TABLES_SQL_SCRIPT_FILENAME = "/sql/initTables.sql";
    private static final String INIT_DATA_SQL_SCRIPT_FILENAME = "/sql/initData.sql";

    private static final String CHECK_ROUND_TABLE = "SELECT count(1) FROM round";
    private static final String CHECK_CATEGORY_TABLE = "SELECT count(1) FROM category";
    private static final String CHECK_TUNE_TABLE = "SELECT count(1) FROM tune";
    private static final String CHECK_SUPERGAME_TABLE = "SELECT count(1) FROM supergame";
    private static final String CHECK_SETTINGS_TABLE = "SELECT count(1) FROM settings";
    private static final String INSERT_INTO_SETTINGS_TABLE = "INSERT INTO settings (key, value) VALUES (?, ?), (?, ?)";
    private static final String[] CHECK_QUERIES = {
            CHECK_ROUND_TABLE,
            CHECK_CATEGORY_TABLE,
            CHECK_TUNE_TABLE,
            CHECK_SUPERGAME_TABLE
    };
    private static final Logger LOGGER = Logger.getLogger(JDBC.class);
    private static JdbcDataSource jdbcDataSource;

    private JDBC() {
    }

    public static void init() {
        jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:./db/nameThatTune");
        initializeTables();
        initializeDataIfNeeded();
    }

    public static JdbcDataSource getJdbcDataSource() {
        return jdbcDataSource;
    }

    private static void initializeTables() {
        try (Connection connection = jdbcDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(getSQLScriptAsString(INIT_TABLES_SQL_SCRIPT_FILENAME));
        } catch (SQLException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private static void initializeDataIfNeeded() {
        if (isEmptyTables(CHECK_QUERIES)) {
            try (Connection connection = jdbcDataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(getSQLScriptAsString(INIT_DATA_SQL_SCRIPT_FILENAME));
            } catch (SQLException | IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        if (isEmptyTables(CHECK_SETTINGS_TABLE)) {
            try (Connection connection = JDBC.getJdbcDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SETTINGS_TABLE)) {
                preparedStatement.setString(1, SettingsUtil.CURRENT_DIRECTORY_KEY);
                preparedStatement.setString(2, SettingsUtil.CURRENT_DIRECTORY_DEFAULT_VALUE);
                preparedStatement.setString(3, SettingsUtil.COUNT_SECONDS_KEY);
                preparedStatement.setString(4, SettingsUtil.COUNT_SECONDS_DEFAULT_VALUE);
                preparedStatement.execute();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    private static boolean isEmptyTables(String... queries) {
        boolean emptyTables = false;
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            for (String checkQuery : queries) {
                try (ResultSet resultSet = statement.executeQuery(checkQuery)) {
                    if (resultSet.next()) {
                        emptyTables |= resultSet.getInt(1) == 0;
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return emptyTables;
    }

    private static String getSQLScriptAsString(String scriptFileName) throws IOException {
        try (InputStream inputStream = JDBC.class.getResourceAsStream(scriptFileName)) {
            byte[] data = IOUtils.toByteArray(inputStream);
            return new String(data, UTF_8);
        }
    }

}
