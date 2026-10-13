package br.com.arthur.transporte_veiculos.DTO.Viagem;

import br.com.arthur.transporte_veiculos.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.server.RemoteObjectInvocationHandler;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemRespostaDTO {
    private Motorista motorista;
    private Equipamento equipamento;
    private Long numero_viagem;
    private List<Veiculo> veiculosList;
    private Filial filial;
    private LocalDate data_prevista_entrega;
    private List<Dealer> dealers;
}
