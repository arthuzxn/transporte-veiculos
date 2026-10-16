package br.com.arthur.transporte_veiculos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TB_DEALER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dealer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo_dealer", nullable = false, unique = true)
    private String codigo_dealer;
    private String nome;
    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true)
    private Endereco endereco;
    @JsonIgnore
    @ManyToMany(mappedBy = "dealers")
    private List<Viagem>viagens;
}
