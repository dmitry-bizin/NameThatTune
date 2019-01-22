import dao.DAO;
import dao.SupergameDAO;
import entity.Supergame;
import org.junit.jupiter.api.Test;

public class SupergameDAOTest implements DAOTest<Supergame> {

    private static final DAO<Supergame> DAO = new SupergameDAO();

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
    public Supergame getNewEntity(Supergame supergame) {
        return new Supergame(supergame.getId(), UPDATE_STRING, UPDATE_STRING);
    }

}
