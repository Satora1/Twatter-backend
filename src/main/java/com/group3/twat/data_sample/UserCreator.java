package com.group3.twat.data_sample;


import com.group3.twat.model.user.service.DAO.UserMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {
    @Autowired
    UserMemory userMemory;

    public void initialize() {
    }

    public UserCreator() {
        initialize();
    }
}
