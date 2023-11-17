package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Doutor;
import semestre4.DesafioProfissional.model.repository.DoutorRepository;

import java.util.List;
@RestController
@RequestMapping("/doutor")
public class DoutorController {
    @Autowired
    private DoutorRepository doutorRepository;

    @GetMapping
    public List<Doutor> allDoutores(){
        return doutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doutor buscaById(@PathVariable Long id){
        return doutorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Doutor gerarDoutor(@RequestBody Doutor novoDoutor){
        return doutorRepository.save(novoDoutor);
    }

    @PutMapping("/{id}")
    public void alteraDoutor(@PathVariable Long id, @RequestBody Doutor alteraDoutor){
        Doutor doutor = doutorRepository.findById(id).orElse(new Doutor());

        doutor.setCrm(alteraDoutor.getCrm());
        doutor.setNome(alteraDoutor.getNome());
        doutor.setIdFunc(alteraDoutor.getIdFunc());
        doutor.setUbs(alteraDoutor.getUbs());

        doutorRepository.save(doutor);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaDoutor(@PathVariable Long id){
        doutorRepository.deleteById(id);
    }
}
