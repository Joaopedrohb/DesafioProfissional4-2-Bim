package semestre4.DesafioProfissional.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import semestre4.DesafioProfissional.model.domain.Paciente;
import semestre4.DesafioProfissional.model.repository.PacienteRepository;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ModelAndView all(){
        List<Paciente> pacientes = pacienteRepository.findAll();

        ModelAndView view = new ModelAndView("list-paciente");
        view.addObject("pacientes", pacienteRepository.findAll());
        return view;
    }

    @GetMapping("/novo")
    public ModelAndView newPaciente() {
        ModelAndView view = new ModelAndView("form-paciente");

        view.addObject("paciente", new Paciente());

        return view;
    }

    @PostMapping
    public String create(Paciente novoPaciente) {
        pacienteRepository.save(novoPaciente);

        return "redirect:/paciente";
    }
    @GetMapping("/delete/{cpf}")
    public String delete(@PathVariable("cpf") Long cpf) {
        pacienteRepository.deleteById(cpf);
        return "redirect:/paciente";
    }

    @GetMapping("/edit/{cpf}")
    public ModelAndView editPaciente(@PathVariable("cpf") Long cpf) {
        Paciente paciente = pacienteRepository.findById(cpf).orElse(null);

        ModelAndView view = new ModelAndView("up-paciente");

        view.addObject("paciente", paciente);

        return view;
    }

}
