package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;


import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
    @Override
    public User getById(Long id) {
        return userDao.findById(id);
    }
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }
    @Override
    public void deleteUserById(Long id) {
        userDao.remove(id);
    }
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }



}
