package br.com.arthur.transporte_veiculos.Entity;


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
    @Column(unique = true)
    private Long numero_viagem;
    @OneToMany(mappedBy = "viagem")
    private List<Veiculo> veiculos;
    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;
    private LocalDateTime momento_emissao;
    private LocalDate data_prevista_entrega;
    private LocalDateTime data_entrega;
    @ManyToMany
    @JoinTable(
            name = "TB_VIAGEM_DEALER",
            joinColumns = @JoinColumn(name = "id_viagem"),
            inverseJoinColumns = @JoinColumn(name = "id_dealer")
    )
    private List<Dealer> dealers;


}
