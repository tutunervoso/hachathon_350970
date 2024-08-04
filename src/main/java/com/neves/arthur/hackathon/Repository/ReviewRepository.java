package com.neves.arthur.hackathon.Repository;

import com.neves.arthur.hackathon.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //@Query("SELECT al_0.valor , al_0.descricao , al_0.metodopagamento , al_0.status FROM Review al_0 WHERE al_0.cpf =?1")
    List<Review> findByCpf(String cpf);
}
