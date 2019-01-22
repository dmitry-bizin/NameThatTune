package dao;

import entity.Round;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoundDAO implements DAO<Round> {

    private static final String READ_ALL = "SELECT * FROM round";
    private static final String READ_BY_ID = "SELECT * FROM round WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE round SET title = ? WHERE id = ?";

    @Override
    public List<Round> readAll() {
        return readAll(READ_ALL);
    }

    @Override
    @Nullable
    public Round readById(int id) {
        return readById(id, READ_BY_ID);
    }

    @Override
    public void updateById(int id, Round round) {
        updateById(id, round, UPDATE_BY_ID);
    }

    @Override
    public Round readFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        return new Round(id, title);
    }

    @Override
    public void fillPreparedStatement(PreparedStatement preparedStatement, int id, Round round) throws SQLException {
        preparedStatement.setString(1, round.getTitle());
        preparedStatement.setInt(2, id);
    }

}
