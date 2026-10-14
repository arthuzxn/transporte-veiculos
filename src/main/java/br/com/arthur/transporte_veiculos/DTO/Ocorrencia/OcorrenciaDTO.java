package br.com.arthur.transporte_veiculos.DTO.Ocorrencia;

import br.com.arthur.transporte_veiculos.Entity.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaDTO {
    private String descricao;
    private Veiculo veiculo;
}
