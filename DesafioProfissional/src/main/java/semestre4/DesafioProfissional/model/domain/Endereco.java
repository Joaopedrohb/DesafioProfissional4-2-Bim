package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DP_ENDERECO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEndereco;

    private String logradouro;

    private String bairro;

    private Integer numero;

    private String complemento;

}
