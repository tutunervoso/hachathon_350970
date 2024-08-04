package com.neves.arthur.hackathon.Controller;

import com.neves.arthur.hackathon.Model.Payment;
import com.neves.arthur.hackathon.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pagamentos")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }

}
