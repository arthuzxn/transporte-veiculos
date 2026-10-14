package br.com.arthur.transporte_veiculos.DTO.Equipamento;

import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipamentoDTO {
    private String placaCavalo;
    private String placaCarreta;
    private String modeloCavalo;
    private String modeloCarreta;
    private Transportadora transportadora;
}
