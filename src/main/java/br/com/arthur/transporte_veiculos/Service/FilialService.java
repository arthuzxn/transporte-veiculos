package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Filial.FilialDTO;
import br.com.arthur.transporte_veiculos.DTO.Filial.FilialMapper;
import br.com.arthur.transporte_veiculos.Entity.Filial;
import br.com.arthur.transporte_veiculos.Repository.FilialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilialService {

    private final FilialRepository filialRepository;
    private final FilialMapper filialMapper;

    public FilialDTO criarFilial(FilialDTO filialDTO){
        Filial filialSalva = filialMapper.map(filialDTO);
        filialRepository.save(filialSalva);
        return filialMapper.map(filialSalva);
    }

    public void deletarFilial(Long id){
        if(!filialRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        filialRepository.deleteById(id);
    }

    public FilialDTO atualizarFilial(Long id,FilialDTO filialDTO){
        if(!filialRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        Filial filial = filialMapper.map(filialDTO);
        filial.setId(id);
        filialRepository.save(filial);
        return filialMapper.map(filial);
    }

    public List<FilialDTO> listarFiliais(){
        return filialRepository.findAll().stream().map(filialMapper::map).toList();
    }

    public FilialDTO buscarFilialId(Long id){
        return filialMapper.map(filialRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado")));
    }
}
