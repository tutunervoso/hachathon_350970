package com.neves.arthur.hackathon.repository;

import com.neves.arthur.hackathon.Model.Client;
import com.neves.arthur.hackathon.Repository.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

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
    void shouldRegisterClient(){
        // Arrange
        var client=Client.builder().cpf("11111111100").nome("Teste").email("teste@teste.teste").telefone("11123456789").rua("Rua Vazia").cidade("Nada").estado("Abismo").cep("00000000").pais("Alem").build();
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        // Act
        var result = clientRepository.save(client);

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(client);
        verify(clientRepository, times(1)).save(any(Client.class));

    }

    @Test
    void shouldFindByCpf(){
        // Arrange
        var client=Client.builder().cpf("11111111100").nome("Teste").email("teste@teste.teste").telefone("11123456789").rua("Rua Vazia").cidade("Nada").estado("Abismo").cep("00000000").pais("Alem").build();
        when(clientRepository.findByCpf("11111111100")).thenReturn(client);

        // Act
        var result = clientRepository.findByCpf("11111111100");

        // Assert
        Assertions.assertThat(result).isNotNull().isEqualTo(client);
        verify(clientRepository, times(1)).findByCpf("11111111100");
    }
}