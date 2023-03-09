import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Model.User;
import Service.UserService;
import Service.UserserviceImpl.UserServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.LENIENT) // я ненавижу эту строчку
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @AfterAll
    public static void chillAndRelax() {
        System.out.println("2) Test has been passed successfully, now relax listening to LO-Fi music!)");
    }
    @Mock
    UserDao userDao = new UserDaoImpl();
    @InjectMocks
    UserService userService = new UserServiceImpl(userDao);
    @Test
    public void checkUserExistReturnsTrue() {
        User existingUser = new User("Egor", 18);
        when(userDao.getUserByName(existingUser.getName())).thenReturn(existingUser);
        assertTrue(userService.checkUserExist(existingUser));
        //работает
    }
    @Test
    public void checkIfFalseUserDoesNotExist() {
        User notExistingUser = new User("Алиса", 2000);
        when(userDao.getUserByName(notExistingUser.getName())).thenReturn(null);
        assertFalse(userService.checkUserExist(notExistingUser));
        //какого то хрена проблема именно здесь, но блеять метод возвращает только false/true, ни о каком null речи и нет
    }
}
