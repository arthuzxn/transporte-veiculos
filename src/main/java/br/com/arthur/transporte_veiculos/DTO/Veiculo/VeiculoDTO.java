package br.com.arthur.transporte_veiculos.DTO.Veiculo;

import br.com.arthur.transporte_veiculos.Entity.Ocorrencia;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import br.com.arthur.transporte_veiculos.Enums.MarcaVeiculo;
import br.com.arthur.transporte_veiculos.Enums.StatusVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    private String chassi;
    private String modelo;
    private MarcaVeiculo marca;
    private StatusVeiculo status;
    private Viagem viagem;
    private List<Ocorrencia> ocorrencias;
}
