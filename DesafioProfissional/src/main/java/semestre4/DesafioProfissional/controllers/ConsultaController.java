package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Atestado;
import semestre4.DesafioProfissional.model.domain.Consulta;
import semestre4.DesafioProfissional.model.repository.ConsultaRepository;

import java.util.List;
@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping
    public List<Consulta> all(){
        return consultaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Consulta buscaById(@PathVariable Long id){
        return consultaRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Consulta gerarConsulta(@RequestBody Consulta novaConsulta){
        return consultaRepository.save(novaConsulta);
    }

    @PutMapping("/{id}")
    public void alteraConsulta(@PathVariable Long id, @RequestBody Consulta alteraConsulta){
        Consulta consulta = consultaRepository.findById(id).orElse(new Consulta());

        consulta.setIdConsulta(alteraConsulta.getIdConsulta());
        consulta.setData(alteraConsulta.getData());
        consulta.setPaciente(alteraConsulta.getPaciente());
        consulta.setDoutor(alteraConsulta.getDoutor());
        consulta.setUbs(alteraConsulta.getUbs());
        consulta.setEspecialidade(alteraConsulta.getEspecialidade());

        consultaRepository.save(consulta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaConsulta(@PathVariable Long id){
        consultaRepository.deleteById(id);
    }
}
