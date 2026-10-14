package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.DTO.Ocorrencia.OcorrenciaDTO;
import br.com.arthur.transporte_veiculos.DTO.Ocorrencia.OcorrenciaMapper;
import br.com.arthur.transporte_veiculos.Entity.Ocorrencia;
import br.com.arthur.transporte_veiculos.Repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {

    private final OcorrenciaRepository ocorrenciaRepository;
    private final OcorrenciaMapper ocorrenciaMapper;

    public OcorrenciaDTO criarOcorrencia(OcorrenciaDTO ocorrenciaDTO){
        Ocorrencia ocorrenciaSalva = ocorrenciaMapper.map(ocorrenciaDTO);
        ocorrenciaRepository.save(ocorrenciaSalva);
        return ocorrenciaMapper.map(ocorrenciaSalva);
    }

    public void deletarOcorrencia(Long id){
        if(!ocorrenciaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "ID "+id+", não encontrado");
        }
        ocorrenciaRepository.deleteById(id);
    }

    public OcorrenciaDTO atualizarOcorrencia(Long id, OcorrenciaDTO ocorrenciaDTO){
        if(!ocorrenciaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "ID "+id+", não encontrado");
        }
        Ocorrencia ocorrencia = ocorrenciaMapper.map(ocorrenciaDTO);
        ocorrencia.setId(id);
        ocorrenciaRepository.save(ocorrencia);
        return OcorrenciaMapper.map(ocorrencia);
    }

    public List<OcorrenciaDTO> listarOcorrencias(){
        return ocorrenciaRepository.findAll().stream().map(OcorrenciaMapper::map).toList();
    }

    public OcorrenciaDTO buscarOcorrenciaId(Long id){
        return OcorrenciaMapper.map(ocorrenciaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado")));
    }

}
