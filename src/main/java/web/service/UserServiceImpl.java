package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;


import javax.validation.Valid;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDao;

    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void saveUser(@Valid User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        User user = userDao.findById(id);
        if (user != null) {
            userDao.remove(user);
        }
    }

    @Override
    @Transactional
    public void updateUser(@Valid User user) {
        userDao.update(user);
    }


}
