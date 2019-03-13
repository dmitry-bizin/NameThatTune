package dao;

import db.JDBC;
import entity.Identifiable;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface DAO<T extends Identifiable> {

    Logger LOGGER = Logger.getLogger(DAO.class);

    List<T> readAll();

    @Nullable
    T readById(int id);

    void updateById(int id, T t);

    T readFromResultSet(ResultSet resultSet) throws SQLException;

    void fillPreparedStatement(PreparedStatement preparedStatement, int id, T t) throws SQLException;

    default List<T> readAll(String sql) {
        List<T> result = new ArrayList<>();
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    result.add(readFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    @Nullable
    default T readById(int id, String sql) {
        T result = null;
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    result = readFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    default void updateById(int id, T t, String sql) {
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            fillPreparedStatement(preparedStatement, id, t);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    default List<T> readByForeignKey(String sql, int foreignKey) {
        List<T> result = new ArrayList<>();
        try (Connection connection = JDBC.getJdbcDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, foreignKey);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(readFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

}
