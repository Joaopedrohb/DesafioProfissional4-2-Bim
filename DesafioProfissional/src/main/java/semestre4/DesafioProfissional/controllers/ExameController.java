package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Exame;
import semestre4.DesafioProfissional.model.repository.ExameRepository;

import java.util.List;
@RestController
@RequestMapping("/exame")
public class ExameController {
    @Autowired
    private ExameRepository exameRepository;

    @GetMapping
    public List<Exame> all(){
        return exameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exame exameById(@PathVariable Long id){
        return exameRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Exame gerarExame(@RequestBody Exame novoExame){
        return exameRepository.save(novoExame);
    }

    @PutMapping("/{id}")
    public void alteraExame (@PathVariable Long id, @RequestBody Exame alteraExame){
        Exame exame = exameRepository.findById(id).orElse(new Exame());

        exame.setIdExame(alteraExame.getIdExame());
        exame.setTipoExame(alteraExame.getTipoExame());
        exame.setIdConsulta(alteraExame.getIdConsulta());
        exame.setHorario(alteraExame.getHorario());

        exameRepository.save(exame);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaExame(@PathVariable Long id){
        exameRepository.deleteById(id);
    }
}
