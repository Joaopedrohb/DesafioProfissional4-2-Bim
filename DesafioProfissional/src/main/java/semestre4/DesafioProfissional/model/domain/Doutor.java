package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import semestre4.DesafioProfissional.model.enuns.Ubs;

@Entity
@Table(name = "DP_DOUTOR")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFunc;

    private String nome;

    @Column(name = "crm", length = 7)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Ubs ubs;

}
