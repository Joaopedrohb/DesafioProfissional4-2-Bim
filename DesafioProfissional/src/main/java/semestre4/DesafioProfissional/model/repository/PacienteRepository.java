package semestre4.DesafioProfissional.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import semestre4.DesafioProfissional.model.domain.Paciente;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {


    Optional<Paciente> findByCpf(String cpf);

    void deleteByCpf(String cpf);
}
