package br.com.arthur.transporte_veiculos.DTO.Endereco;


import br.com.arthur.transporte_veiculos.Entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRespostaDTO {
    private String cep;
    private String logradouro;
    private Short numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais = "Brasil";
}