package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getById(Long id);

    void saveUser(User user);

    void deleteUserById(Long id);

    void updateUser(User user);
}
