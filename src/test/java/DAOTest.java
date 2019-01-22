import dao.DAO;
import entity.Identifiable;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public interface DAOTest<T extends Identifiable> {

    String UPDATE_STRING = "test";
    int UPDATE_INT = 1;

    void readAllTest();

    default void readAll(DAO<T> dao) {
        try {
            dao.readAll();
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    void readByIdTest();

    default void readById(DAO<T> dao) {
        List<T> entities = dao.readAll();
        for (T t : entities) {
            T r = dao.readById(t.getId());
            Assertions.assertEquals(t, r);
        }
    }

    void updateByIdTest();

    default void updateById(DAO<T> dao) {
        List<T> entities = dao.readAll();
        for (T t : entities) {
            T newEntity = getNewEntity(t);
            dao.updateById(t.getId(), newEntity);
            T r = dao.readById(t.getId());
            Assertions.assertEquals(newEntity, r);
            dao.updateById(t.getId(), t);
            r = dao.readById(t.getId());
            Assertions.assertEquals(t, r);
        }
    }

    T getNewEntity(T t);

}
