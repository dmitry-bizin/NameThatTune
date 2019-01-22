import dao.DAO;
import dao.RoundDAO;
import entity.Round;
import org.junit.jupiter.api.Test;

public class RoundDAOTest implements DAOTest<Round> {

    private static final DAO<Round> DAO = new RoundDAO();

    @Override
    @Test
    public void readAllTest() {
        readAll(DAO);
    }

    @Override
    @Test
    public void readByIdTest() {
        readById(DAO);
    }

    @Override
    @Test
    public void updateByIdTest() {
        updateById(DAO);
    }

    @Override
    public Round getNewEntity(Round round) {
        return new Round(round.getId(), UPDATE_STRING);
    }

}
