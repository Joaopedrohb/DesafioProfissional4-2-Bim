package semestre4.DesafioProfissional.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import semestre4.DesafioProfissional.model.domain.Doutor;
import semestre4.DesafioProfissional.model.enuns.Ubs;
import semestre4.DesafioProfissional.model.repository.DoutorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DoutorControllerTest {

    @InjectMocks
    private DoutorController doutorController;

    @Mock
    private DoutorRepository doutorRepository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void todosDoutores() {
        List<Doutor> allDoutores = List.of(new Doutor(2L, "kenjinho doutor", "BH1234", Ubs.MORANGUEIRA));
        when(doutorRepository.findAll()).thenReturn(allDoutores);
        List<Doutor> result = doutorController.allDoutores();
        
        verify(doutorRepository, times(1)).findAll();
        Assertions.assertEquals("kenjinho doutor", result.get(0).getNome());
    }

    @Test
    void doutorById() {
        Doutor doutor = new Doutor(2L, "kenjinho doutor", "BH1234", Ubs.MORANGUEIRA);
        when(doutorRepository.findById(any())).thenReturn(Optional.of(doutor));
        Doutor result = doutorController.buscaById(any());

        verify(doutorRepository, times(1)).findById(any());
        Assertions.assertEquals("kenjinho doutor", result.getNome());
    }

    @Test
    void gerarDoutor() {
        Doutor doutor = new Doutor(2L, "kenjinho doutor", "BH1234", Ubs.MORANGUEIRA);
        when(doutorRepository.save(doutor)).thenReturn(doutor);

        Doutor result = doutorController.gerarDoutor(doutor);

        Assertions.assertEquals("kenjinho doutor", result.getNome());
    }

    @Test
    void alteraDoutor() {
        Doutor doutor = new Doutor(2L, "kenjinho doutor", "BH1234", Ubs.MORANGUEIRA);
        doutorController.alteraDoutor(2L, doutor);

        verify(doutorRepository, times(1)).save(doutor);
    }

}