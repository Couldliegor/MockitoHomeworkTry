import Dao.UserDao;
import Model.User;
import Service.UserserviceImpl.UserServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @AfterAll
    public static void chillAndRelax() {
        System.out.println("2) Test has been passed successfully, now relax listening to LO-Fi music!)");
    }

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    public void checkUserExistReturnsTrue() {
        User mockedUser = new User("Some user", 18);
        when(userDao.getUserByName(mockedUser.getName())).thenReturn(mockedUser);
        assertTrue(userService.checkUserExist(mockedUser));
        //работает
    }

    @Test
    public void checkIfFalseUserDoesNotExist() {
        User mockedUser = new User("Some user", 2000);
        when(userDao.getUserByName(mockedUser.getName())).thenReturn(null);
        assertFalse(userService.checkUserExist(mockedUser));
    }
}
