package br.com.arthur.transporte_veiculos.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "TB_TRANSPORTADORA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transportadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cnpj;
    @JsonIgnore
    @OneToMany(mappedBy = "transportadora")
    private List<Motorista> motoristas;
    @JsonIgnore
    @OneToMany(mappedBy = "transportadora")
    private List<Equipamento> equipamentos;

}
