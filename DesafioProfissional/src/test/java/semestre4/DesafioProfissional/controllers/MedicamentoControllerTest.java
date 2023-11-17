package semestre4.DesafioProfissional.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import semestre4.DesafioProfissional.model.domain.Medicamento;
import semestre4.DesafioProfissional.model.enuns.TipoMedicamento;
import semestre4.DesafioProfissional.model.repository.MedicamentoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MedicamentoControllerTest {

    @InjectMocks
    private MedicamentoController medicamentoController;

    @Mock
    private MedicamentoRepository medicamentoRepository;

    @BeforeEach
    private void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void all() {
        List<Medicamento> allMedicamentos = List.of(new Medicamento(2L, "Dipirona", TipoMedicamento.ANALGESICO));
        when(medicamentoRepository.findAll()).thenReturn(allMedicamentos);
        List<Medicamento> result = medicamentoController.all();

        verify(medicamentoRepository, times(1)).findAll();
        Assertions.assertEquals("Dipirona", result.get(0).getNome());
    }

    @Test
    void medicamento() {
        Medicamento medicamento = new Medicamento(2L, "Dipirona", TipoMedicamento.ANALGESICO);
        when(medicamentoRepository.findById(any())).thenReturn(Optional.of(medicamento));
        Medicamento result = medicamentoController.BuscaById(any());

        verify(medicamentoRepository, times(1)).findById(any());
        Assertions.assertEquals("Dipirona", result.getNome());
    }

    @Test
    void geraMedicamento() {
        Medicamento medicamento = new Medicamento(2L, "Dipirona", TipoMedicamento.ANALGESICO);
        when(medicamentoRepository.save(medicamento)).thenReturn(medicamento);

        Medicamento result = medicamentoController.geraMedicamento(medicamento);

        Assertions.assertEquals("Dipirona", result.getNome());
    }

    @Test
    void alteraMedicamento() {
        Medicamento medicamento = new Medicamento(2L, "Dipirona", TipoMedicamento.ANALGESICO);
        medicamentoController.alteraMedicamento(2L, medicamento);

        verify(medicamentoRepository, times(1)).save(medicamento);

    }

}