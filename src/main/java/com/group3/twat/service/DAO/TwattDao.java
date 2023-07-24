package com.group3.twat.service.DAO;

import com.group3.twat.model.Twatt;

import java.util.List;

public interface TwattDao {
    List<Twatt> getTwatt();

    void addTwatt(Twatt newTwatt);

    boolean deleteTwattById(Long twattId);
}
