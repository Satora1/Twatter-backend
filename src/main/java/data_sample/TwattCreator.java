package data_sample;

import service.DAO.TwattMemory;
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