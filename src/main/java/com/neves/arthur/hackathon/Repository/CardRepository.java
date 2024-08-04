package com.neves.arthur.hackathon.Repository;

import com.neves.arthur.hackathon.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findByCpf(String Cpf);

    Card findByNumero(String numero);
}
