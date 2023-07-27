package com.group3.twat.controller;

import com.group3.twat.model.post.service.TwattService;
import com.group3.twat.model.post.Twatt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class TwattController {



        private final TwattService twattService;

        @Autowired
        public TwattController(TwattService twattService) {
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


    @DeleteMapping("/twatts/{twatId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteTwattById(@PathVariable Long twatId) {
        boolean deleted = twattService.deleteTwattById(twatId);
        if (deleted) {
            return ResponseEntity.ok("Twatt deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
