package com.group3.twat;

import com.group3.twat.posts.service.PostValidator;
import com.group3.twat.posts.service.Post_DB;
import com.group3.twat.users.service.UserDB;
import com.group3.twat.users.service.UserValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwatterApplication {

    public static void main(String[] args) {
        Post_DB postDatabase = null;
        PostValidator postValidator = null;

        UserDB userDatabase = null;
        UserValidator userValidator = null;


        //SpringApplication.run(TwatterApplication.class, args);
    }

}
