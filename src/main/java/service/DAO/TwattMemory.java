package service.DAO;

import model.Twatt;
import org.springframework.stereotype.Repository;
import service.DAO.TwattDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class TwattMemory implements TwattDao {
    private List<Twatt> twatts;
    public TwattMemory() {
        this.twatts = new ArrayList<>(Arrays.asList(
                Twatt.builder().id(1L).body("super udany dzień").build(),
                Twatt.builder().id(12L).body("lubię czekoladę").build()
        ));
    }

    @Override
    public List<Twatt> getTwatt() {
        return twatts;
    }


    @Override
    public void addTwatt(Twatt newTwatt) {
        twatts.add(newTwatt);
    }
}
