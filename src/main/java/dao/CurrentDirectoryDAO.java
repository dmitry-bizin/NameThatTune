package dao;

import db.JDBC;
import entity.CurrentDirectory;
import org.jetbrains.annotations.Nullable;

import java.sql.*;

public class CurrentDirectoryDAO {

    private static final String READ = "SELECT path FROM currentDirectory";
    private static final String UPDATE = "UPDATE currentDirectory SET path = ?";

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
            e.printStackTrace();
        }
        return result;
    }

    public void update(CurrentDirectory currentDirectory) {
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, currentDirectory.getPath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
