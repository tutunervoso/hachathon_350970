package com.neves.arthur.hackathon.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewid;
    private String cpf;
    private Double valor;
    private String descricao;
    private String metodopagamento;
    private String status;

    public Review(String cpf, Double valor, String descricao, String metodopagamento, String status) {
        this.cpf=cpf;
        this.valor=valor;
        this.descricao=descricao;
        this.metodopagamento=metodopagamento;
        this.status=status;
    }

    public Review(Double valor, String descricao, String metodopagamento, String status) {
        this.valor=valor;
        this.descricao=descricao;
        this.metodopagamento=metodopagamento;
        this.status=status;
    }
}