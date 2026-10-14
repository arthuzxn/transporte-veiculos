package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Motorista.MotoristaDTO;
import br.com.arthur.transporte_veiculos.DTO.Motorista.MotoristaMapper;
import br.com.arthur.transporte_veiculos.Entity.Motorista;
import br.com.arthur.transporte_veiculos.Repository.MotoristaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final MotoristaMapper motoristaMapper;

    public MotoristaDTO criarMotorista(MotoristaDTO motoristaDTO){
        Motorista motoristaSalvo = motoristaMapper.map(motoristaDTO);
        motoristaRepository.save(motoristaSalvo);
        return motoristaMapper.map(motoristaSalvo);
    }

    public void deletarMotorista(Long id){
        if(!motoristaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
        }
        motoristaRepository.deleteById(id);
    }

    public MotoristaDTO atualizarMotorista(Long id, MotoristaDTO motoristaDTO){
        if(!motoristaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
        }
        Motorista motorista = motoristaMapper.map(motoristaDTO);
        motorista.setId(id);
        motoristaRepository.save(motorista);
        return motoristaMapper.map(motorista);
    }

    public List<MotoristaDTO> listarMotoristas(){
        return motoristaRepository.findAll().stream().map(motoristaMapper::map).toList();
    }

    public MotoristaDTO buscarMotoristaId(Long id){
        return motoristaMapper.map(motoristaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado" )));
    }

    //VERIFICAR MOTORISTA ATIVO
    public boolean motoristaAtivo(Long id){
        MotoristaDTO motorista = buscarMotoristaId(id);
        return motorista.isAtivo();
    }

}

