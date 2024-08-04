package com.neves.arthur.hackathon.repository;

import com.neves.arthur.hackathon.Model.Review;
import com.neves.arthur.hackathon.Repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ReviewRepositoryTest {

    @Mock
    private ReviewRepository reviewRepository;

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
        var review= Review.builder().cpf("11111111100").valor(20.00).descricao("Alguma compra").metodopagamento("Cartão de crédito").status("Aprovado").build();
        when(reviewRepository.save(any(Review.class))).thenReturn(review);

        // Act
        var result = reviewRepository.save(review);

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(review);
        verify(reviewRepository, times(1)).save(any(Review.class));

    }

    @Test
    void shouldFindById(){
        // Arrange
        var review= Review.builder().cpf("11111111100").valor(20.00).descricao("Alguma compra").metodopagamento("Cartão de crédito").status("Aprovado").build();
        List<Review> lista = new ArrayList<>();
        lista.add(review);
        when(reviewRepository.findByCpf("11111111100")).thenReturn(lista);

        // Act
        var result = reviewRepository.findByCpf("11111111100");

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(lista);
        verify(reviewRepository, times(1)).findByCpf("11111111100");

    }
}
