package br.com.arthur.transporte_veiculos.DTO.Motorista;


import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaDTO {
    private String cpf;
    private String nome;
    private List<Viagem> viagens;
    private LocalDate dataNascimento;
    private Transportadora transportadora;
    private boolean ativo;
    private String numero_motorista;
}
