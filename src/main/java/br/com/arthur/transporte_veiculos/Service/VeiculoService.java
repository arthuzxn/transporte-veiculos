package br.com.arthur.transporte_veiculos.Service;


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

    public Veiculo criarVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Long id){
        if(!veiculoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        veiculoRepository.deleteById(id);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo veiculo){
        if(!veiculoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo buscarVeiculoId(Long id){
        return veiculoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado"));
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
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veiculo para ser entregue precisa estar embarcado");
            }
            veiculo.setStatus(StatusVeiculo.ENTREGUE);
            veiculoRepository.save(veiculo);
        }
    }


}
