package br.com.arthur.transporte_veiculos.DTO.Viagem;

import br.com.arthur.transporte_veiculos.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemConsultaDTO {
    private Motorista motorista;
    private Equipamento equipamento;
    private Long numero_viagem;
    private List<Veiculo> veiculos;
    private Filial filial;
    private LocalDateTime momento_emissao;
    private LocalDate data_prevista_entrega;
    private LocalDateTime data_entrega;
    private List<Dealer> dealers;
}
