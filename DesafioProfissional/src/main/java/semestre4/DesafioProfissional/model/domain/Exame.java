package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import semestre4.DesafioProfissional.model.enuns.TipoExame;

import java.util.Date;

@Entity
@Table(name = "DP_EXAME")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExame;

    private Long idConsulta;

    private Date horario;

    private TipoExame tipoExame;
}
