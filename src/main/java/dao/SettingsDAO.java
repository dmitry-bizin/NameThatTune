package dao;

import db.JDBC;
import entity.Setting;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SettingsDAO {

    private static final Logger LOGGER = Logger.getLogger(SettingsDAO.class);
    private static final String READ_BY_KEY = "SELECT value FROM settings WHERE key = ?";
    private static final String UPDATE_BY_KEY = "UPDATE settings SET value = ? WHERE key = ?";

    @Nullable
    public String readByKey(String key) {
        String value = null;
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(READ_BY_KEY)) {
            preparedStatement.setString(1, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    value = resultSet.getString("value");
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return value;
    }

    public void update(Setting setting) {
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_KEY)) {
            preparedStatement.setString(1, setting.getValue());
            preparedStatement.setString(2, setting.getKey());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
