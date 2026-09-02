package br.com.arthur.transporte_veiculos.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ENDERECO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private Short numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @Column(nullable = false)
    private String pais = "Brasil";
}
