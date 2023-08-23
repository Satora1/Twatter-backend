package com.group3.twat.model.user.service;

import com.group3.twat.model.group.Group;
import com.group3.twat.model.user.User;
import com.group3.twat.model.user.service.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUser() {
        return userDao.getUser();
    }


    public void addUser(User newUser) {
        userDao.addUser(newUser);
    }


    public void addUserToFriend(Long userId, Long friendId) {
       userDao.addUserToFriend(userId, friendId);
    }
    public boolean removeUserFromFriends(Long userId, Long friendId) {
        return userDao.removeUserFromFriends(userId, friendId);
    }

}
