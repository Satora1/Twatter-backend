package com.group3.twat.controller;

import com.group3.twat.controller.requests.ValidationRequest;
import com.group3.twat.controller.requests.ValidationResponse;
import com.group3.twat.model.user.User;
import com.group3.twat.model.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControler {




    private final UserService userService;

    @Autowired
    public UserControler(UserService userService) {
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

    @PostMapping("/user/validate")
    public ValidationResponse validate(@RequestBody ValidationRequest request){
        System.out.println("Validate");
        System.out.println(request.email() + " " + request.password());
        return new ValidationResponse(true, true);
    }
}
