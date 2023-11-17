package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Receita;
import semestre4.DesafioProfissional.model.repository.ReceitaRepository;

import java.util.List;
@RestController
@RequestMapping("/receita")
public class ReceitaController {
    @Autowired
    private ReceitaRepository receitaRepository;

    @GetMapping
    public List<Receita> all(){
        return receitaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Receita buscaById(@PathVariable Long id){
        return receitaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Receita geraReceita(@RequestBody Receita novaReceita){
        return receitaRepository.save(novaReceita);
    }

    @PutMapping("/{id}")
    public void alteraReceita(@PathVariable Long id, @RequestBody Receita alteraReceita){
        Receita receita = receitaRepository.findById(id).orElse(new Receita());

        receita.setIdReceita(alteraReceita.getIdReceita());
        receita.setDosagem(alteraReceita.getDosagem());
        receita.setQuantidade(alteraReceita.getQuantidade());
        receita.setObservacao(alteraReceita.getObservacao());
        receita.setValidade(alteraReceita.getValidade());
        receita.setIdConsulta(alteraReceita.getIdConsulta());
        receita.setMedicamentos(alteraReceita.getMedicamentos());

        receitaRepository.save(receita);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaReceita(@PathVariable Long id){
        receitaRepository.deleteById(id);
    }

}
