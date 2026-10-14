package br.com.arthur.transporte_veiculos.DTO.Transportadora;

import br.com.arthur.transporte_veiculos.Controller.TransportadoraController;
import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import org.springframework.stereotype.Component;

@Component
public class TransportadoraMapper {

    public Transportadora map(TransportadoraDTO transportadoraDTO){
        Transportadora transportadora = new Transportadora();
        transportadora.setCnpj(transportadoraDTO.getCnpj());
        transportadora.setNome(transportadoraDTO.getNome());
        transportadora.setMotoristas(transportadoraDTO.getMotoristas());
        transportadora.setEquipamentos(transportadoraDTO.getEquipamentos());
        return transportadora;
    }

    public static TransportadoraDTO map(Transportadora transportadora){
        TransportadoraDTO  transportadoraDTO = new TransportadoraDTO();
        transportadoraDTO.setCnpj(transportadora.getCnpj());
        transportadoraDTO.setNome(transportadora.getNome());
        transportadoraDTO.setMotoristas(transportadora.getMotoristas());
        transportadoraDTO.setEquipamentos(transportadora.getEquipamentos());
        return transportadoraDTO;
    }
}
