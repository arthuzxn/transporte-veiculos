package Entity;


import Enums.MarcaVeiculo;
import Enums.StatusVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_VEICULO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Veiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chassi;
    private String modelo;
    @Enumerated(EnumType.STRING)
    private MarcaVeiculo marca;
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;
    @ManyToOne
    @JoinColumn(name = "viagem_id")
    private Viagem viagem;
    @OneToMany(mappedBy = "veiculo")
    private List<Ocorrencia> ocorrencias;

}
