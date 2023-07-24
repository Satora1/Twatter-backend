package controller;

import model.Twatt;
import service.TwattService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class TwattControler {



        private final TwattService twattService;

        @Autowired
        public TwattControler(TwattService twattService) {
            this.twattService = twattService;
        }

    @GetMapping("/twatts")
    public List<Twatt> getTwatts() {
        return twattService.getAllTwats();
    }

    @PostMapping("/twatts")
    public String addTwatt(@RequestBody Twatt newTwatt) {
        twattService.addTwatt(newTwatt);
        return "redirect:/twatts";
    }
}
