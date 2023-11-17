package semestre4.DesafioProfissional.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import semestre4.DesafioProfissional.model.domain.Adm;
import semestre4.DesafioProfissional.model.enuns.Ubs;
import semestre4.DesafioProfissional.model.repository.AdmRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdmControllerTest {

    @InjectMocks
    private AdmController admControler;

    @Mock
    private AdmRepository admRepository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    };

    @Test
    public void todosAdm() {
        List<Adm> allAdms = List.of(new Adm(1L, "kenjinho adm", Ubs.MORANGUEIRA));
        when(admRepository.findAll()).thenReturn(allAdms);
        List<Adm> result = admControler.todosAdm();

        verify(admRepository,times(1)).findAll();
        Assertions.assertEquals("kenjinho adm", result.get(0).getNome());
    }

    @Test
    public void buscaById() {
        Adm adm = new Adm(1L,"kenjinho adm", Ubs.MORANGUEIRA);
        when(admRepository.findById(any())).thenReturn(Optional.of(adm));

        Adm result = admControler.buscaById(any());

        verify(admRepository, times(1)).findById(any());
        Assertions.assertEquals("kenjinho adm", result.getNome());
    }

    @Test
    public void gerarAdm() {
        Adm adm = new Adm(2L, "kenjinho adm", Ubs.JARDIM_PARIS);
        when(admRepository.save(adm)).thenReturn(adm);

        Adm result = admControler.gerarAdm(adm);

        Assertions.assertEquals("kenjinho adm", result.getNome() );
    }

    @Test
    public void alteraAdm() {
        Adm adm = new Adm(2L, "kenjinho adm", Ubs.JARDIM_PARIS);
        admControler.alteraAdm(2L, adm);

        verify(admRepository, times(1)).save(adm);

    }

}