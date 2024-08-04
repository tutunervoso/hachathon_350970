package com.neves.arthur.hackathon.Service;

import com.neves.arthur.hackathon.Model.Card;
import com.neves.arthur.hackathon.Model.Client;
import com.neves.arthur.hackathon.Repository.CardRepository;
import com.neves.arthur.hackathon.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> registerCard(Card card) {
        Client client;
        try {
            client = clientRepository.findByCpf(card.getCpf());
            List<Card> verify=cardRepository.findByCpf(card.getCpf());
            if (verify.size()==2){
                return ResponseEntity.status(HttpStatusCode.valueOf(403)).body("número máximo de cartões atingido");
            }
        } catch (NullPointerException ex) {
            client = null;
        }
        if (client != null) {
            cardRepository.save(card);
            return ResponseEntity.ok(card);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não cadastro");
        }
    }
}
