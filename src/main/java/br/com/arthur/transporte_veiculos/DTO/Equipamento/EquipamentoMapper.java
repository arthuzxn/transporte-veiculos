package br.com.arthur.transporte_veiculos.DTO.Equipamento;

import br.com.arthur.transporte_veiculos.Entity.Equipamento;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {

    public Equipamento map(EquipamentoDTO equipamentoDTO){
        Equipamento equipamento = new Equipamento();
        equipamento.setPlacaCavalo(equipamentoDTO.getPlacaCavalo());
        equipamento.setPlacaCarreta(equipamentoDTO.getPlacaCarreta());
        equipamento.setModeloCavalo(equipamentoDTO.getModeloCavalo());
        equipamento.setModeloCarreta(equipamentoDTO.getModeloCarreta());
        equipamento.setTransportadora(equipamentoDTO.getTransportadora());
        return equipamento;
    }

    public EquipamentoDTO map(Equipamento equipamento){
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO();
        equipamentoDTO.setPlacaCavalo(equipamento.getPlacaCavalo());
        equipamentoDTO.setPlacaCarreta(equipamento.getPlacaCarreta());
        equipamentoDTO.setModeloCavalo(equipamento.getModeloCavalo());
        equipamentoDTO.setModeloCarreta(equipamento.getModeloCarreta());
        equipamentoDTO.setTransportadora(equipamento.getTransportadora());
        return equipamentoDTO;
    }
}
