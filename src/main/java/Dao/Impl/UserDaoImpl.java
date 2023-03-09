package Dao.Impl;

import Dao.UserDao;
import Model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //  создвть мапу
    List<User> list = List.of(
            new User("Egor", 18),
            new User("Grisha", 19),
            new User("Alexa", 21),
            new User("Marina", 23));
    public User getUserByName(String name) {
        for (User user : list) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAllUser() {
        return list;
    }

}
