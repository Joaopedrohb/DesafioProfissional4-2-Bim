package semestre4.DesafioProfissional.controllers;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import semestre4.DesafioProfissional.model.domain.Endereco;
import semestre4.DesafioProfissional.model.repository.EnderecoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public  class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoRepository enderecoRepository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void all() {
        List<Endereco> allEnderecos = List.of(new Endereco(1L, "rua kenjinho",  "bairro kenjinho", 666, "casa do kenji" ));
        when(enderecoRepository.findAll()).thenReturn(allEnderecos);
        List<Endereco> result = enderecoController.all();

        verify(enderecoRepository, times(1)).findAll();
        Assertions.assertEquals("rua kenjinho", allEnderecos.get(0).getLogradouro());
    }

    @Test
    void endereco() {
        Endereco endereco = new Endereco(1L, "rua kenjinho",  "bairro kenjinho", 666, "casa do kenji");
        when(enderecoRepository.findById(any())).thenReturn(Optional.of(endereco));
        Endereco result = enderecoController.buscaById(any());

        verify(enderecoRepository, times(1)).findById(any());
        Assertions.assertEquals("rua kenjinho", result.getLogradouro());
    }

    @Test
    void gerarEndereco() {
        Endereco endereco = new Endereco(1L, "rua kenjinho",  "bairro kenjinho", 666, "casa do kenji");
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco result = enderecoController.gerarEndereco(endereco);

        Assertions.assertEquals("rua kenjinho", result.getLogradouro());
    }

    @Test
    void alteraEndereco() {
        Endereco endereco = new Endereco(1L, "rua kenjinho",  "bairro kenjinho", 666, "casa do kenji");
        enderecoController.alteraEndereco(2L, endereco);

        verify(enderecoRepository, times(1)).save(endereco);
    }

}