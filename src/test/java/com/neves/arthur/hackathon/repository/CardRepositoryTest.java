package com.neves.arthur.hackathon.repository;

import com.neves.arthur.hackathon.Model.Card;
import com.neves.arthur.hackathon.Repository.CardRepository;
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

public class CardRepositoryTest {

    @Mock
    private CardRepository cardRepository;

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
        var card= Card.builder().cpf("11111111100").limite(1000.00).numero("0000111100001111").data_validade("12/24").cvv("002").build();
        when(cardRepository.save(any(Card.class))).thenReturn(card);

        // Act
        var result = cardRepository.save(card);

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(card);
        verify(cardRepository, times(1)).save(any(Card.class));

    }

    @Test
    void shouldFindByCpf(){
        // Arrange
        var card= Card.builder().cpf("11111111100").limite(1000.00).numero("0000111100001111").data_validade("12/24").cvv("002").build();
        List<Card> lista = new ArrayList<>();
        lista.add(card);
        when(cardRepository.findByCpf("11111111100")).thenReturn(lista);

        // Act
        var result = cardRepository.findByCpf("11111111100");

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(lista);
        verify(cardRepository, times(1)).findByCpf("11111111100");

    }

    @Test
    void shouldFindByNumero(){
        // Arrange
        var card= Card.builder().cpf("11111111100").limite(1000.00).numero("0000111100001111").data_validade("12/24").cvv("002").build();
        when(cardRepository.findByNumero("0000111100001111")).thenReturn(card);

        // Act
        var result = cardRepository.findByNumero("0000111100001111");

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(card);
        verify(cardRepository, times(1)).findByNumero("0000111100001111");

    }
}
