import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Model.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    public UserDao userDao = new UserDaoImpl();

    @AfterAll
    public static void chillAndRelax() {
        System.out.println("1) Test has been passed successfully, now relax listening to LO-Fi music!)");
    }
    @Test
    public void shouldReturnUserByNameAndIfEquals() {
        User expected = new User("Egor", 18);
        assertEquals(expected, userDao.getUserByName(expected.getName()));
    }

    @Test
    public void shouldReturnNullIfThereIsNoNameInCollection() {
        assertNull(userDao.getUserByName("egor"));
    }

    @Test
    public void classesOfReturnValueAndExpectedShouldBeTheSame() {
        List<User> expected = List.of(
                new User("Egor", 18),
                new User("Grisha", 19),
                new User("Alexa", 21),
                new User("Marina", 23));
        assertEquals(expected, userDao.findAllUser());
    }
}
