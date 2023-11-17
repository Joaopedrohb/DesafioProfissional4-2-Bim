package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Adm;
import semestre4.DesafioProfissional.model.repository.AdmRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmRepository admRepository;

    @GetMapping
    public List<Adm> todosAdm(){
        return admRepository.findAll();
    }

    @GetMapping("/{id}")
    public Adm buscaById(@PathVariable Long id){
        return admRepository.findById(id).orElseThrow();
    }

    @PostMapping()
    public Adm gerarAdm(@RequestBody Adm novoAdm){
        return admRepository.save(novoAdm);
    }

    @PutMapping("/{id}")
    public void alteraAdm( @PathVariable Long id, @RequestBody Adm alteraAdm){
        Adm administrador = admRepository.findById(id).orElse(new Adm());

        administrador.setIdFunc(alteraAdm.getIdFunc());
        administrador.setNome(alteraAdm.getNome());
        administrador.setUbs(alteraAdm.getUbs());

        admRepository.save(administrador);
    }

    @DeleteMapping("/{id}")
    @Transactional
        public void deletaAdm(@PathVariable Long id){
        admRepository.deleteById(id);
    }



}
