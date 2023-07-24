package com.group3.twat.data_sample;

import com.group3.twat.model.post.service.DAO.TwattMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TwattCreator {

    @Autowired
    TwattMemory twattMemory;

    public void initialize() {
    }

    public TwattCreator() {
        initialize();
    }
}