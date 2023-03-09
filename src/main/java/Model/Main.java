package Model;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Service.UserService;
import Service.UserserviceImpl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user = new User("Egor", 18);
        UserDao userDao = new UserDaoImpl();
        UserService userService = new UserServiceImpl(userDao);
        System.out.println(userService.checkUserExist(user));
        User user2 = new User("Alisa", 18);
        System.out.println(userService.checkUserExist(user2));
    }
}
