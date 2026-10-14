package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Transportadora.TransportadoraDTO;
import br.com.arthur.transporte_veiculos.DTO.Transportadora.TransportadoraMapper;
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
    private  final TransportadoraMapper transportadoraMapper;

    public TransportadoraDTO criarTransportadora(TransportadoraDTO transportadoraDTO){
        Transportadora transportadoraSalva = transportadoraMapper.map(transportadoraDTO);
        transportadoraRepository.save(transportadoraSalva);
        return transportadoraMapper.map(transportadoraSalva);
    }

    public void deletarTransportadora(Long id){
        if(!transportadoraRepository.existsById(id)){
            throw new EmptyResultDataAccessException("ID não encontrado", 1);
        }
        transportadoraRepository.deleteById(id);
    }

    public TransportadoraDTO atualizarTransportadora(Long id, TransportadoraDTO transportadoraDTO){
        if(!transportadoraRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado");
        }
        Transportadora transportadora = transportadoraMapper.map(transportadoraDTO);
        transportadora.setId(id);
        transportadoraRepository.save(transportadora);
        return TransportadoraMapper.map(transportadora);
    }

    public List<TransportadoraDTO> listarTransportadoras(){
        return transportadoraRepository.findAll().stream().map(TransportadoraMapper::map).toList();
    }

    public TransportadoraDTO buscarTransportadoraId(Long id) {
        return TransportadoraMapper.map(transportadoraRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado")));
    }

}
