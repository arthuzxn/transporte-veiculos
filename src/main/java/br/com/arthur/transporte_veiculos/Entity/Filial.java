package br.com.arthur.transporte_veiculos.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name="TB_FILIAL")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoFilial;
    private String apelido;
    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true)
    private Endereco endereco;
    @OneToMany(mappedBy = "filial")
    private List<Viagem> viagens;



}
