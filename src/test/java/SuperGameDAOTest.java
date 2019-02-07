import dao.DAO;
import dao.SuperGameDAO;
import entity.SuperGame;
import org.junit.jupiter.api.Test;

public class SuperGameDAOTest implements DAOTest<SuperGame> {

    private static final DAO<SuperGame> DAO = new SuperGameDAO();

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
    public SuperGame getNewEntity(SuperGame superGame) {
        return new SuperGame(superGame.getId(), UPDATE_STRING, UPDATE_STRING);
    }

}
