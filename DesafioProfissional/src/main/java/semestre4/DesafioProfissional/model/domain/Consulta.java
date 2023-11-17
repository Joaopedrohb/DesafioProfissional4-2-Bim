package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import semestre4.DesafioProfissional.model.enuns.Ubs;

import java.util.Date;


@Entity
@Table(name = "DP_CONSULTA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConsulta;

    private String especialidade;

    @Column(name = "DATA")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_doutor")
    private Doutor doutor;

    @Enumerated(EnumType.STRING)
    private Ubs ubs;

}
