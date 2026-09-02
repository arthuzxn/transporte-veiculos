package Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_VIAGEM")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    private Long numeroViagem;
    @OneToMany(mappedBy = "viagem")
    private List<Veiculo> veiculos;
    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;
    private LocalDate dataEmissao;
    private LocalDate dataPrevista;
    private LocalDateTime momentoEntrega;
    @ManyToMany
    @JoinTable(
            name = "ViagemDealer",
            joinColumns = @JoinColumn(name = "id_viagem"),
            inverseJoinColumns = @JoinColumn(name = "id_dealer")
    )
    private List<Dealer> dealers;


}
