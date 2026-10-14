package br.com.arthur.transporte_veiculos.DTO.Veiculo;

import br.com.arthur.transporte_veiculos.Entity.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper {

    public Veiculo map(VeiculoDTO veiculoDTO){
        Veiculo veiculo = new Veiculo();
        veiculo.setChassi(veiculoDTO.getChassi());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setStatus(veiculoDTO.getStatus());
        veiculo.setViagem(veiculoDTO.getViagem());
        veiculo.setOcorrencias(veiculoDTO.getOcorrencias());
        return veiculo;
    }
    public static VeiculoDTO map(Veiculo veiculo){
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setChassi(veiculo.getChassi());
        veiculoDTO.setModelo(veiculo.getModelo());
        veiculoDTO.setMarca(veiculo.getMarca());
        veiculoDTO.setStatus(veiculo.getStatus());
        veiculoDTO.setViagem(veiculo.getViagem());
        veiculoDTO.setOcorrencias(veiculo.getOcorrencias());
        return veiculoDTO;
    }
}
