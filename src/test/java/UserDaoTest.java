import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    public UserDao userDao = new UserDaoImpl();

    @AfterAll
    public static void chillAndRelax() {
        System.out.println("1) Test has been passed successfully, now relax listening to LO-Fi music!)");
    }

    @Test
    public void shouldReturnUserByName() {
        assertEquals(userDao.getUserByName("Egor").getClass(), User.class);
    }

    @Test
    public void shouldReturnNullIfThereIsNoNameInCollection() {
        assertNull(userDao.getUserByName("egor"));
    }

    @Test
    public void classesOfReturnValueAndExpectedShouldBeTheSame() {
        assertEquals(User.class, userDao.getUserByName("Egor").getClass());
    }
}
