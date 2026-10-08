package br.com.arthur.transporte_veiculos.Service;

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

    public Motorista criarMotorista(Motorista motorista){
        return motoristaRepository.save(motorista);
    }

    public void deletarMotorista(Long id){
        if(!motoristaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
        }
        motoristaRepository.deleteById(id);
    }

    public Motorista atualizarMotorista(Long id, Motorista motorista){
        if(motoristaRepository.existsById(id)){
            motorista.setId(id);
            return motoristaRepository.save(motorista);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
    }

    public List<Motorista> listarMotoristas(){
        return motoristaRepository.findAll();
    }

    public Motorista buscarMotoristaId(Long id){
        return motoristaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado" ));
    }

    //VERIFICAR MOTORISTA ATIVO
    public boolean motoristaAtivo(Long id){
        Motorista motorista = buscarMotoristaId(id);
        return motorista.isAtivo();
    }

}

