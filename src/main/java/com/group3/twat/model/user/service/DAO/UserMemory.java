package com.group3.twat.model.user.service.DAO;

import com.group3.twat.model.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class UserMemory implements UserDao {
private List<User> user ;

public UserMemory (){
    this.user=new ArrayList<>(Arrays.asList(


            User.builder().id(1L).email("test@wp.pl").username("chocolate").password("ziemniaki").build()

    ));
}
    @Override
    public List<User> getUser() {
        return user;
    }


    @Override
    public void addUser(User newUser) {
        String plainPassword = newUser.getPassword();
        String hashedPassword = hashPassword(plainPassword);
        newUser.setId((user.get(user.size()-1).getId()+1));
        newUser.setPassword(hashedPassword);
        user.add(newUser);
    }
    private String hashPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
    }
    public boolean isPasswordCorrect(String plainPassword, String hashedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}
