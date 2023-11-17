package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import semestre4.DesafioProfissional.model.enuns.TipoMedicamento;

@Entity
@Table(name = "DP_MEDICAMENTO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private TipoMedicamento tipoMedicamento;
}
