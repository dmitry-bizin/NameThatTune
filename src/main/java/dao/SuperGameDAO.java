package dao;

import entity.SuperGame;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SuperGameDAO implements DAO<SuperGame> {

    private static final String READ_ALL = "SELECT * FROM supergame";
    private static final String READ_BY_ID = "SELECT * FROM supergame WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE supergame SET title = ?, author = ? WHERE id = ?";

    @Override
    public List<SuperGame> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public SuperGame readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, SuperGame superGame) {
        updateById(id, superGame, UPDATE_BY_ID);
    }

    @Override
    public SuperGame readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        return new SuperGame(id, title, author);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, SuperGame superGame) throws SQLException {
        preparedStatement.setString(1, superGame.getTitle());
        preparedStatement.setString(2, superGame.getAuthor());
        preparedStatement.setInt(3, id);
    }

}
