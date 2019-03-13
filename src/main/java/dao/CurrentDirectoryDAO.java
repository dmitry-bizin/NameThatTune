package dao;

import db.JDBC;
import entity.CurrentDirectory;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.sql.*;

public class CurrentDirectoryDAO {

    private static final String READ = "SELECT path FROM currentDirectory";
    private static final String UPDATE = "UPDATE currentDirectory SET path = ?";
    private static final Logger LOGGER = Logger.getLogger(CurrentDirectoryDAO.class);

    @Nullable
    public CurrentDirectory read() {
        CurrentDirectory result = null;
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(READ)) {
                if (resultSet.next()) {
                    String path = resultSet.getString("path");
                    result = new CurrentDirectory(path);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public void update(CurrentDirectory currentDirectory) {
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, currentDirectory.getPath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
