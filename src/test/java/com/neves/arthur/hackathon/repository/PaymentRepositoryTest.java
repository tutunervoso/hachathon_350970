package com.neves.arthur.hackathon.repository;

import com.neves.arthur.hackathon.Model.Payment;
import com.neves.arthur.hackathon.Repository.PaymentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PaymentRepositoryTest {

    @Mock
    private PaymentRepository paymentRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception{
        openMocks.close();
    }

    @Test
    void shouldRegisterCard(){
        // Arrange
        var payment= Payment.builder().cpf("11111111100").numero("0000111100001111").data_validade("12/24").cvv("002").valor(20.00).build();
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        // Act
        var result = paymentRepository.save(payment);

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(payment);
        verify(paymentRepository, times(1)).save(any(Payment.class));

    }
}
