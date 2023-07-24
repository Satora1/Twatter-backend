package service.DAO;

import model.Twatt;

import java.util.List;

public interface TwattDao {
    List<Twatt> getTwatt();

    void addTwatt(Twatt newTwatt);
}
