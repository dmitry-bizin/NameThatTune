package dao;

import entity.Melody;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MelodyDAO implements DAO<Melody> {

    private static final String READ_ALL = "SELECT * FROM melody";
    private static final String READ_BY_ID = "SELECT * FROM melody WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE melody SET title = ?, author = ?, score = ? WHERE id = ?";

    @Override
    public List<Melody> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public Melody readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, Melody melody) {
        updateById(id, melody, UPDATE_BY_ID);
    }

    @Override
    public Melody readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int score = resultSet.getInt("score");
        int categoryId = resultSet.getInt("categoryId");
        return new Melody(id, title, author, score, categoryId);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, Melody melody) throws SQLException {
        preparedStatement.setString(1, melody.getTitle());
        preparedStatement.setString(2, melody.getAuthor());
        preparedStatement.setInt(3, melody.getScore());
        preparedStatement.setInt(4, id);
    }

}
