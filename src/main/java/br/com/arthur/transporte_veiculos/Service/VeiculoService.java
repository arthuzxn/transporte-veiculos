package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.DTO.Veiculo.VeiculoDTO;
import br.com.arthur.transporte_veiculos.DTO.Veiculo.VeiculoMapper;
import br.com.arthur.transporte_veiculos.Entity.Veiculo;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import br.com.arthur.transporte_veiculos.Enums.StatusVeiculo;
import br.com.arthur.transporte_veiculos.Repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoMapper veiculoMapper;

    public VeiculoDTO criarVeiculo(VeiculoDTO veiculoDTO){
        Veiculo veiculoSalvo = veiculoMapper.map(veiculoDTO);
        veiculoRepository.save(veiculoSalvo);
        return veiculoMapper.map(veiculoSalvo);
    }

    public void deletarVeiculo(Long id){
        if(!veiculoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        veiculoRepository.deleteById(id);
    }

    public VeiculoDTO atualizarVeiculo(Long id, VeiculoDTO veiculoDTO){
        if(!veiculoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        Veiculo veiculo = veiculoMapper.map(veiculoDTO);
        veiculo.setId(id);
        veiculoRepository.save(veiculo);
        return VeiculoMapper.map(veiculo);
    }

    public List<VeiculoDTO> listarVeiculos(){
        return veiculoRepository.findAll().stream().map(VeiculoMapper::map).toList();
    }

    public VeiculoDTO buscarVeiculoId(Long id){
        return VeiculoMapper.map(veiculoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado")));
    }

    public void embarcandoVeiculo(Viagem viagem, List<Veiculo> veiculosParaEmbarcar){
        for(Veiculo veicle: veiculosParaEmbarcar ){
            Veiculo veiculo = veiculoRepository.findById(veicle.getId())
                    .orElseThrow(() -> new RuntimeException(
                            "Veículo não encontrado: " + veicle.getId()
                    ));
            if(veiculo.getStatus() == StatusVeiculo.EMBARCADO || veiculo.getStatus() == StatusVeiculo.ENTREGUE ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veiculo Indisponivel");
            }
            veiculo.setViagem(viagem);
            veiculo.setStatus(StatusVeiculo.EMBARCADO);
            veiculoRepository.save(veiculo);
        }
    }

    public void veiculoEntregue(Viagem viagem, List<Veiculo> veiculosEntregues){
        for(Veiculo veiculo: veiculosEntregues ){
            if(veiculo.getStatus() != StatusVeiculo.EMBARCADO){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veiculo não pode ser entregue sem estar embarcado");
            }
            veiculo.setStatus(StatusVeiculo.ENTREGUE);
            veiculoRepository.save(veiculo);
        }
    }


}
