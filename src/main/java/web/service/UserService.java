package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getById(Long id);
    public void saveUser(User user);
    public void deleteUserById(Long id);
    public void updateUser(User user);
}
