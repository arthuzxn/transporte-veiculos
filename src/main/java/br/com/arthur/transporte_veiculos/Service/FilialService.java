package br.com.arthur.transporte_veiculos.Service;

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

    public Filial criarFilial(Filial filial){
        return filialRepository.save(filial);
    }

    public void deletarFilial(Long id){
        if(!filialRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        filialRepository.deleteById(id);
    }

    public Filial atualizarFilial(Long id,Filial filial){
        if(!filialRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        filial.setId(id);
        return filialRepository.save(filial);
    }

    public List<Filial> listarFiliais(){
        return filialRepository.findAll();
    }

    public Filial buscarFilialId(Long id){
        return filialRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+", não encontrado"));
    }
}
