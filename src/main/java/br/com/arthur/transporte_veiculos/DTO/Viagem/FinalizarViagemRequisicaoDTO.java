package br.com.arthur.transporte_veiculos.DTO.Viagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalizarViagemRequisicaoDTO {
    private LocalDateTime data_entrega;
}
