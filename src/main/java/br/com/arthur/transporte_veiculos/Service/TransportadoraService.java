package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import br.com.arthur.transporte_veiculos.Repository.TransportadoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransportadoraService {

    private final TransportadoraRepository transportadoraRepository;

    public Transportadora criarTransportadora(Transportadora transportadora){
        return transportadoraRepository.save(transportadora);
    }

    public void deletarTransportadora(Long id){
        if(!transportadoraRepository.existsById(id)){
            throw new EmptyResultDataAccessException("ID não encontrado", 1);
        }
        transportadoraRepository.deleteById(id);
    }

    public Transportadora atualizarTransportadora(Long id, Transportadora transportadora){
        if(transportadoraRepository.existsById(id)){
            transportadora.setId(id);
            return transportadoraRepository.save(transportadora);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
    }

    public List<Transportadora> listarTransportadoras(){
        return transportadoraRepository.findAll();
    }

    public Transportadora buscarTransportadoraId(Long id) {
        return transportadoraRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado"));
    }

}
