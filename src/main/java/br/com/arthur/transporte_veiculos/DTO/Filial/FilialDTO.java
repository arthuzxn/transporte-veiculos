package br.com.arthur.transporte_veiculos.DTO.Filial;

import br.com.arthur.transporte_veiculos.Entity.Endereco;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialDTO {
    private String codigoFilial;
    private String apelido;
    private Endereco endereco;
    private List<Viagem> viagens;
}
