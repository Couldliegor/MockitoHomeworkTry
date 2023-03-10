package Service.UserserviceImpl;

import Dao.UserDao;
import Model.User;
import Service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        return userDao.getUserByName(user.getName()) != null;
    }
}
