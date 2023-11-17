package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import semestre4.DesafioProfissional.model.enuns.Ubs;

import java.lang.annotation.Documented;

@Entity
@Table(name = "DP_ADM")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Adm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFunc;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Ubs ubs;
}
