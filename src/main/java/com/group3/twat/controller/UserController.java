package com.group3.twat.controller;

import com.group3.twat.model.user.User;
import com.group3.twat.model.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {




    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User newUser) {
        userService.addUser(newUser);
        return "redirect:/user";
    }

}
