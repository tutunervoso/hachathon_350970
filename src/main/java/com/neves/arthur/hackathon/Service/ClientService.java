package com.neves.arthur.hackathon.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.neves.arthur.hackathon.Model.Client;
import com.neves.arthur.hackathon.Repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> registrar(Client client){
        clientRepository.save(client);
        Client prov=clientRepository.findByCpf(client.getCpf());
        return ResponseEntity.ok("\"id_cliente\":\""+prov.getClientid()+ "\"");
    }

}
