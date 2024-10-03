package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getHomeUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());// не знаю правильно ли так делать,
        return "redirect:/users";  // но без двух практически одинаковых методов у меня не работало направление на домашнюю страницу юзерс
    }
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String editUser(@RequestParam Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editUser";
    }
    @PostMapping("/users/update")
    public String updateUser(@RequestParam Long id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email) {
        User user = userService.getById(id);
        if (user != null) {
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            userService.updateUser(user);
        }
        return "redirect:/users";
    }
    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

}
