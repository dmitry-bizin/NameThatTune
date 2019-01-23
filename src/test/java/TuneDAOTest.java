import dao.DAO;
import dao.TuneDAO;
import entity.Tune;
import org.junit.jupiter.api.Test;

public class TuneDAOTest implements DAOTest<Tune> {

    private static final DAO<Tune> DAO = new TuneDAO();

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
    public Tune getNewEntity(Tune tune) {
        return new Tune(tune.getId(), UPDATE_STRING, UPDATE_STRING, UPDATE_INT, tune.getCategoryId());
    }

}
