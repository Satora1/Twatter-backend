package com.group3.twat.service;

import com.group3.twat.service.DAO.TwattDao;
import com.group3.twat.model.Twatt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwattService {


    private final TwattDao twattDao;

    @Autowired
    public TwattService(TwattDao twattDao) {
        this.twattDao = twattDao;
    }

    public List<Twatt> getAllTwats() {
        return twattDao.getTwatt();
    }


    public void addTwatt(Twatt newTwat) {
        twattDao.addTwatt(newTwat);
    }

    public boolean deleteTwattById(Long twattId) {
        {
            return twattDao.deleteTwattById(twattId);
        }
    }
}