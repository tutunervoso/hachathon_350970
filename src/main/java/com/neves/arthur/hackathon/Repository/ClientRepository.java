package com.neves.arthur.hackathon.Repository;

import com.neves.arthur.hackathon.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByCpf(String cpf);
}
