package com.neves.arthur.hackathon.Controller;

import com.neves.arthur.hackathon.Model.Card;
import com.neves.arthur.hackathon.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartao")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<?> registerCard(@RequestBody Card card){
        return cardService.registerCard(card);
    }
}
