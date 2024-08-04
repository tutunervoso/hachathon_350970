package com.neves.arthur.hackathon.Repository;

import com.neves.arthur.hackathon.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
