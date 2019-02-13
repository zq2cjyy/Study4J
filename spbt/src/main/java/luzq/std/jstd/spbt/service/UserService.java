package luzq.std.jstd.spbt.service;

import luzq.std.jstd.spbt.dao.master.UserDao;
import luzq.std.jstd.spbt.model.master.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
}
