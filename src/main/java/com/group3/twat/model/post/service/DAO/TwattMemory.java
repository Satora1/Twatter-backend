package com.group3.twat.model.post.service.DAO;

import com.group3.twat.model.post.Twatt;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Repository
public class TwattMemory implements TwattDao {
    private List<Twatt> twatts;
    public TwattMemory() {
        this.twatts = new ArrayList<>(Arrays.asList(
                Twatt.builder().id(1L).userId(1L).text("super udany dzień").date(LocalDate.of(2023, 7, 24)).build(),
                Twatt.builder().id(12L).userId(1L).text("lubię czekoladę").date(LocalDate.of(2022, 4, 2)).build()
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
    @Override
    public boolean  deleteTwattById(Long twattId){
        Iterator<Twatt> iterator = twatts.iterator();
        while (iterator.hasNext()) {
            Twatt twatt = iterator.next();
            if (twatt.getId().equals(twattId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
