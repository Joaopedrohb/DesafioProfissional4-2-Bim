package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Adm;
import semestre4.DesafioProfissional.model.domain.Atestado;
import semestre4.DesafioProfissional.model.repository.AtestadoRepository;

import java.util.List;
@RestController
@RequestMapping("/atestado")
public class AtestadoController {

    @Autowired
    private AtestadoRepository atestadoRepository;

    @GetMapping
    public List<Atestado> todosAtestados(){
        return atestadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Atestado BuscaById(@PathVariable Long id){
        return atestadoRepository.findById(id).orElse(null);
    }

    @PostMapping()
    public Atestado gerarAtestado(@RequestBody Atestado novoAtestado){
        return atestadoRepository.save(novoAtestado);
    }

    @PutMapping
    public void alteraAtestado(@PathVariable Long id, @RequestBody Atestado alteraAtestado){
        Atestado atestado = atestadoRepository.findById(id).orElse(new Atestado());

        atestado.setIdAtestado(alteraAtestado.getIdAtestado());
        atestado.setIdConsulta(alteraAtestado.getIdConsulta());
        atestado.setDataEmissao(alteraAtestado.getDataEmissao());
        atestado.setCid(alteraAtestado.getCid());
        atestado.setValidade(alteraAtestado.getValidade());

        atestadoRepository.save(atestado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaAtestado(@PathVariable Long id){
        atestadoRepository.deleteById(id);
    }


}
