import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import org.junit.jupiter.api.Test;

public class CategoryDAOTest implements DAOTest<Category> {

    private static final DAO<Category> DAO = new CategoryDAO();

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
    public Category getNewEntity(Category category) {
        return new Category(category.getId(), UPDATE_STRING, category.getRoundId());
    }

}
