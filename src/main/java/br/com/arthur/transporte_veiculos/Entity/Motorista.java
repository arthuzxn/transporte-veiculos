package br.com.arthur.transporte_veiculos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_MOTORISTA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    @JsonIgnore
    @OneToMany(mappedBy = "motorista")
    private List<Viagem> viagens;
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "transportadora_id")
    private Transportadora transportadora;
    private boolean ativo;
}
