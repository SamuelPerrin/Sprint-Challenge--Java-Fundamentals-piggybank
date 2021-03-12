package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

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
            String noun = c.getNumber() > 1 ? c.getPluralname() : c.getSingname();
            result += c.getNumber() + " " + noun + "\n";
            total += c.getNumber() * c.getValue();
        }
        result += "The piggy bank holds " + total;
        System.out.println(result);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
