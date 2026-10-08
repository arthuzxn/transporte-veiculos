package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.Entity.Equipamento;
import br.com.arthur.transporte_veiculos.Repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public Equipamento criarEquipamento(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public void deletarEquipamento(Long id){
        if(!equipamentoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }

    public Equipamento atualizarEquipamento(Long id, Equipamento equipamento){
        if(equipamentoRepository.existsById(id)){
            equipamento.setId(id);
            return equipamentoRepository.save(equipamento);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
    }

    public List<Equipamento> listarEquipamentos(){
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarEquipamentoId(Long id){
        return equipamentoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID"+id+", não encontrado"));
    }

}
