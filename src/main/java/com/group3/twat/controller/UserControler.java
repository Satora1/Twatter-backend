package com.group3.twat.controller;

import com.group3.twat.controller.requests.UserRegistrationRequest;
import com.group3.twat.controller.requests.ValidationRequest;
import com.group3.twat.controller.requests.ValidationResponse;
import com.group3.twat.model.user.User;
import com.group3.twat.model.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserControler {


    private final UserService userService;

    @Autowired
    public UserControler(UserService userService) {
        this.userService = userService;
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public User getUserByID(@PathVariable Long id) {
        System.out.println(id);
        List<User> userList = userService.getUser();
        return userList.stream().filter(e->e.getId()==id).findFirst().get();
    }



    @PostMapping("/user/{userId}/addFriend/{friendId}")
    public ResponseEntity<String> addFriend(
            @PathVariable Long userId,
            @PathVariable Long friendId) {

        try {
            userService.addUserToFriend(userId, friendId);
            return ResponseEntity.ok("Friend added successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add friend");
        }
    }

    @DeleteMapping("/user/{userId}/removeFriend/{friendId}")
    public ResponseEntity<String> removeFriend(
            @PathVariable Long userId,
            @PathVariable Long friendId) {

        boolean success = userService.removeUserFromFriends(userId, friendId);
        if (success) {
            return ResponseEntity.ok("Friend removed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to remove friend");
        }
    }

}
