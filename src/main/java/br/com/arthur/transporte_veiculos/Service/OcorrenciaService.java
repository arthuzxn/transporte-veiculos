package br.com.arthur.transporte_veiculos.Service;


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

    public Ocorrencia criarOcorrencia(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void deletarOcorrencia(Long id){
        if(!ocorrenciaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "ID "+id+", não encontrado");
        }
        ocorrenciaRepository.deleteById(id);
    }

    public Ocorrencia atualizarOcorrencia(Long id, Ocorrencia ocorrencia){
        if(!ocorrenciaRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "ID "+id+", não encontrado");
        }
        ocorrencia.setId(id);
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> listarOcorrencias(){
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia buscarOcorrenciaId(Long id){
        return ocorrenciaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado"));
    }

}
