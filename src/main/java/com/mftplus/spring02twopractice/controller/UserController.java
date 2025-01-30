package com.mftplus.spring02twopractice.controller;


import com.mftplus.spring02twopractice.model.entity.User;
import com.mftplus.spring02twopractice.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("user", new User());
        log.info("saved users {}", userService.findAll());
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        log.info("found user with id {}", userService.findUserById(id));
        model.addAttribute("user", userService.findUserById(id));
        return "editUsers";

    }
    @GetMapping("/username/{username}")
    public String getUserByUsername(@PathVariable String username, Model model) {
        log.info("found user with username {}", userService.findUserByUsername(username));
        model.addAttribute("user", userService.findUserByUsername(username));
        return "editUsers";

    }

    @PostMapping
    public String saveUser(User user) {
        userService.save(user);
        log.info("saved user {}", user);
        return "redirect:/users";

    }

    @PutMapping
    public String updateUser(User user) {
        userService.update(user);
        log.info("updated user {}", user);
        return "redirect:/users";

    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @DeleteMapping("/username/{username}")
    public String deleteUserByUsername(@PathVariable String username) {
        userService.delete(userService.findUserByUsername(username));
        return "redirect:/users";
    }
}
