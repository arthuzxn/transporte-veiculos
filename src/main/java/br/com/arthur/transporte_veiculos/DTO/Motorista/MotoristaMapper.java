package br.com.arthur.transporte_veiculos.DTO.Motorista;

import br.com.arthur.transporte_veiculos.Entity.Motorista;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    public MotoristaDTO map(Motorista motorista){
        MotoristaDTO motoristaDTO = new MotoristaDTO();
        motoristaDTO.setCpf(motorista.getCpf());
        motoristaDTO.setNumero_motorista(motorista.getNumero_motorista());
        motoristaDTO.setAtivo(motorista.isAtivo());
        motoristaDTO.setNome(motorista.getNome());
        motoristaDTO.setViagens(motorista.getViagens());
        motoristaDTO.setDataNascimento(motorista.getDataNascimento());
        motoristaDTO.setTransportadora(motorista.getTransportadora());
        return motoristaDTO;
    }

    public Motorista map(MotoristaDTO motoristaDTO){
        Motorista motorista = new Motorista();
        motorista.setCpf(motoristaDTO.getCpf());
        motorista.setNumero_motorista(motoristaDTO.getNumero_motorista());
        motorista.setAtivo(motoristaDTO.isAtivo());
        motorista.setNome(motoristaDTO.getNome());
        motorista.setViagens(motoristaDTO.getViagens());
        motorista.setDataNascimento(motoristaDTO.getDataNascimento());
        motorista.setTransportadora(motoristaDTO.getTransportadora());
        return motorista;
    }
}
