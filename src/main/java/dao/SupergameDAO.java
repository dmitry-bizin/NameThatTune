package dao;

import entity.Supergame;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupergameDAO implements DAO<Supergame> {

    private static final String READ_ALL = "SELECT * FROM supergame";
    private static final String READ_BY_ID = "SELECT * FROM supergame WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE supergame SET title = ?, author = ? WHERE id = ?";

    @Override
    public List<Supergame> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public Supergame readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, Supergame supergame) {
        updateById(id, supergame, UPDATE_BY_ID);
    }

    @Override
    public Supergame readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        return new Supergame(id, title, author);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, Supergame supergame) throws SQLException {
        preparedStatement.setString(1, supergame.getTitle());
        preparedStatement.setString(2, supergame.getAuthor());
        preparedStatement.setInt(3, id);
    }

}
