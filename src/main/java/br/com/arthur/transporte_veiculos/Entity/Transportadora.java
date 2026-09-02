package br.com.arthur.transporte_veiculos.Entity;

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
    private String cnpj;
    @OneToMany(mappedBy = "transportadora")
    private List<Motorista> motoristas;
    @OneToMany(mappedBy = "transportadora")
    private List<Equipamento> equipamentos;

}
