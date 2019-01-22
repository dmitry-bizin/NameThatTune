package db;

import org.apache.commons.io.IOUtils;
import org.h2.jdbcx.JdbcDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JDBC {

    private static final String INIT_TABLES_SQL_SCRIPT_FILENAME = "/sql/initTables.sql";
    private static final String INIT_DATA_SQL_SCRIPT_FILENAME = "/sql/initData.sql";

    private static final String CHECK_ROUND_TABLE = "SELECT count(1) FROM round";
    private static final String CHECK_CATEGORY_TABLE = "SELECT count(1) FROM category";
    private static final String CHECK_MELODY_TABLE = "SELECT count(1) FROM melody";
    private static final String CHECK_SUPERGAME_TABLE = "SELECT count(1) FROM supergame";
    private static final String CHECK_CURRENT_DIRECTORY_TABLE = "SELECT count(1) FROM currentDirectory";
    private static final String INSERT_INTO_CURRENT_DIRECTORY_TABLE = "INSERT INTO currentDirectory (path) VALUES (?)";
    private static final String[] CHECK_QUERIES = {
            CHECK_ROUND_TABLE,
            CHECK_CATEGORY_TABLE,
            CHECK_MELODY_TABLE,
            CHECK_SUPERGAME_TABLE
    };
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
            e.printStackTrace();
        }
    }

    private static void initializeDataIfNeeded() {
        if (isEmptyTables(CHECK_QUERIES)) {
            try (Connection connection = jdbcDataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.execute(getSQLScriptAsString(INIT_DATA_SQL_SCRIPT_FILENAME));
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        if (isEmptyTables(CHECK_CURRENT_DIRECTORY_TABLE)) {
            try (Connection connection = JDBC.getJdbcDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CURRENT_DIRECTORY_TABLE)) {
                preparedStatement.setString(1, System.getProperty("user.home"));
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
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
            e.printStackTrace();
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
