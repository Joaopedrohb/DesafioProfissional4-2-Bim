package semestre4.DesafioProfissional.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import semestre4.DesafioProfissional.model.domain.Consulta;
@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
