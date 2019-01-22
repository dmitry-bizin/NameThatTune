import dao.DAO;
import dao.MelodyDAO;
import entity.Melody;
import org.junit.jupiter.api.Test;

public class MelodyDAOTest implements DAOTest<Melody> {

    private static final DAO<Melody> DAO = new MelodyDAO();

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
    public Melody getNewEntity(Melody melody) {
        return new Melody(melody.getId(), UPDATE_STRING, UPDATE_STRING, UPDATE_INT, melody.getCategoryId());
    }

}
