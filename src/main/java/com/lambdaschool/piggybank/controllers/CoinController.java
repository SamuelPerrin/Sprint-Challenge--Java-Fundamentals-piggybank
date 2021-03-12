package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {
    @Autowired
    CoinRepository coinrepo;

    @GetMapping(value = "/total", produces={"application/json"})
    public ResponseEntity<?> getTotalValue() {
        List<Coin> coins = new ArrayList<>();
        coinrepo.findAll()
                .iterator()
                .forEachRemaining(coins::add);
        double total = 0;
        String result = "";
        for (Coin c : coins) {
            String noun = c.getQuantity() > 1 ? c.getNameplural() : c.getName();
            result += c.getQuantity() + " " + noun + "\n";
            total += c.getQuantity() * c.getValue();
        }
        result += "The piggy bank holds " + total;
        System.out.println(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
