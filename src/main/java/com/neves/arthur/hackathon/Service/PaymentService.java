package com.neves.arthur.hackathon.Service;

import com.neves.arthur.hackathon.Model.Card;
import com.neves.arthur.hackathon.Model.Payment;
import com.neves.arthur.hackathon.Model.Review;
import com.neves.arthur.hackathon.Repository.CardRepository;
import com.neves.arthur.hackathon.Repository.PaymentRepository;
import com.neves.arthur.hackathon.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<?> addPayment(Payment payment) {
        Card card;
        try {
            card = cardRepository.findByNumero(payment.getNumero());
        } catch (NullPointerException ex) {
            card = null;
        }
        if (card != null) {
            if (payment.getCpf().equals(card.getCpf()) && payment.getNumero().equals(card.getNumero()) && payment.getData_validade().equals(card.getData_validade()) && payment.getCvv().equals(card.getCvv())) {
                if (payment.getValor() <= card.getLimite()) {
                    paymentRepository.save(payment);
                    card.setLimite(card.getLimite() - payment.getValor());
                    cardRepository.save(card);
                    Review review= new Review(payment.getCpf(), payment.getValor(),"Compra de algo","cartao_credito","aprovado");
                    reviewRepository.save(review);
                    return ResponseEntity.ok(card);
                } else {
                    Review review= new Review(payment.getCpf(),payment.getValor(),"Acima do limite","cartao_credito","reprovado");
                    reviewRepository.save(review);
                    return ResponseEntity.status(HttpStatusCode.valueOf(402)).body("Estorou o limite");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não cadastrado");
        }
    }
}
