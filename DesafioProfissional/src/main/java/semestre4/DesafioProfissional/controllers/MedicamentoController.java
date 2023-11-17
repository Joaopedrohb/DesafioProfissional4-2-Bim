package semestre4.DesafioProfissional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Medicamento;
import semestre4.DesafioProfissional.model.repository.MedicamentoRepository;

import java.util.List;
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @GetMapping
    public List<Medicamento> all(){
        return medicamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medicamento BuscaById(@PathVariable Long id){
        return medicamentoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Medicamento geraMedicamento(@RequestBody Medicamento novoMedicamento){
        return medicamentoRepository.save(novoMedicamento);
    }

    @PutMapping("/{id}")
    public void alteraMedicamento(@PathVariable Long id, @RequestBody Medicamento alteraMedicamento){
        Medicamento medicamento = medicamentoRepository.findById(id).orElse(new Medicamento());

        medicamento.setId(alteraMedicamento.getId());
        medicamento.setNome(alteraMedicamento.getNome());
        medicamento.setTipoMedicamento(alteraMedicamento.getTipoMedicamento());

        medicamentoRepository.save(medicamento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaMedicamento(@PathVariable Long id){
        medicamentoRepository.deleteById(id);
    }
}
