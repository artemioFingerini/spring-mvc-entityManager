package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
    public User findById(Long id);
    public void save(User user);
    public void remove(Long id);
    public void update(User user);

}
