package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semestre4.DesafioProfissional.model.domain.Endereco;
import semestre4.DesafioProfissional.model.repository.EnderecoRepository;

import java.util.List;
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> all(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Endereco buscaById(@PathVariable Long id){
        return enderecoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Endereco gerarEndereco(@RequestBody Endereco novoEndereco){
        return enderecoRepository.save(novoEndereco);
    }

    @PutMapping("/{id}")
    public void alteraEndereco(@PathVariable Long id, @RequestBody Endereco alteraEndereco){
        Endereco endereco = enderecoRepository.findById(id).orElse(new Endereco());

        endereco.setIdEndereco(alteraEndereco.getIdEndereco());
        endereco.setLogradouro(alteraEndereco.getLogradouro());
        endereco.setNumero(alteraEndereco.getNumero());
        endereco.setBairro(alteraEndereco.getBairro());
        endereco.setComplemento(alteraEndereco.getComplemento());

        enderecoRepository.save(endereco);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletaEndereco(@PathVariable Long id){
        enderecoRepository.deleteById(id);
    }

}
