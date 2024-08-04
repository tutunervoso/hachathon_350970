package com.neves.arthur.hackathon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.neves.arthur.hackathon.Model.Client;
import com.neves.arthur.hackathon.Service.ClientService;

@RestController
@RequestMapping("/api/cliente")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Client client){
        return clientService.registrar(client);
    }
}