package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DP_RECEITA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReceita;

    @Column(nullable = false)
    @NotNull
    private Long idConsulta;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "id_medicamento")
    private List<Medicamento> medicamentos;

    private Date validade;

    private Integer quantidade;

    private String observacao;

    private Double dosagem;



}
