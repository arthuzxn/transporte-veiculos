package br.com.arthur.transporte_veiculos.Entity;


import br.com.arthur.transporte_veiculos.Enums.MarcaVeiculo;
import br.com.arthur.transporte_veiculos.Enums.StatusVeiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(unique = true)
    private String chassi;
    private String modelo;
    @Enumerated(EnumType.STRING)
    private MarcaVeiculo marca;
    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "viagem_id")
    private Viagem viagem;
    @JsonIgnore
    @OneToMany(mappedBy = "veiculo")
    private List<Ocorrencia> ocorrencias;

}
