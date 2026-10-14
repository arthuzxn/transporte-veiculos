package br.com.arthur.transporte_veiculos.DTO.Dealer;

import br.com.arthur.transporte_veiculos.Entity.Endereco;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealerDTO {
    private String codigo_dealer;
    private String nome;
    private Endereco endereco;
    private List<Viagem> viagens;
}
