package semestre4.DesafioProfissional.model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@Entity
@Table(name = "DP_ATESTADO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atestado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAtestado;

    private Long IdConsulta;

    private Date dataEmissao;

    private Date validade;

    private String cid;
}
