package br.com.arthur.transporte_veiculos.DTO.Transportadora;

import br.com.arthur.transporte_veiculos.Entity.Equipamento;
import br.com.arthur.transporte_veiculos.Entity.Motorista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportadoraDTO {
    private String nome;
    private String cnpj;
    private List<Motorista> motoristas;
    private List<Equipamento> equipamentos;
}
