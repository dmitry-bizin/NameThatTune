package dao;

import entity.Category;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements DAO<Category> {

    private static final String READ_ALL = "SELECT * FROM category";
    private static final String READ_BY_ID = "SELECT * FROM category WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE category SET title = ? WHERE id = ?";

    @Override
    public List<Category> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public Category readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, Category category) {
        updateById(id, category, UPDATE_BY_ID);
    }

    @Override
    public Category readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int roundId = resultSet.getInt("roundId");
        return new Category(id, title, roundId);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, Category category) throws SQLException {
        preparedStatement.setString(1, category.getTitle());
        preparedStatement.setInt(2, id);
    }

}
