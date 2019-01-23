package dao;

import entity.Tune;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TuneDAO implements DAO<Tune> {

    private static final String READ_ALL = "SELECT * FROM tune";
    private static final String READ_BY_ID = "SELECT * FROM tune WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE tune SET title = ?, author = ?, score = ? WHERE id = ?";

    @Override
    public List<Tune> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public Tune readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, Tune tune) {
        updateById(id, tune, UPDATE_BY_ID);
    }

    @Override
    public Tune readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        int score = resultSet.getInt("score");
        int categoryId = resultSet.getInt("categoryId");
        return new Tune(id, title, author, score, categoryId);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, Tune tune) throws SQLException {
        preparedStatement.setString(1, tune.getTitle());
        preparedStatement.setString(2, tune.getAuthor());
        preparedStatement.setInt(3, tune.getScore());
        preparedStatement.setInt(4, id);
    }

}
