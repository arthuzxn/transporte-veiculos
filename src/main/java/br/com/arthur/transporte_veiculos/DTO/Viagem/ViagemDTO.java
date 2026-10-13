package br.com.arthur.transporte_veiculos.DTO.Viagem;


import br.com.arthur.transporte_veiculos.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemDTO {
    private Motorista motorista;
    private Equipamento equipamento;
    private Long numero_viagem;
    private List<Veiculo> veiculos;
    private Filial filial;
    private List<Dealer> dealers;
}
