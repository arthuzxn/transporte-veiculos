package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.DTO.Equipamento.EquipamentoDTO;
import br.com.arthur.transporte_veiculos.DTO.Equipamento.EquipamentoMapper;
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
    private final EquipamentoMapper equipamentoMapper;

    public EquipamentoDTO criarEquipamento(EquipamentoDTO equipamentoDTO){
        Equipamento equipamentoSalvo = equipamentoMapper.map(equipamentoDTO);
        equipamentoRepository.save(equipamentoSalvo);
        return equipamentoMapper.map(equipamentoSalvo);
    }

    public void deletarEquipamento(Long id){
        if(!equipamentoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }

    public EquipamentoDTO atualizarEquipamento(Long id, EquipamentoDTO equipamentoDTO){
        if(!equipamentoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        Equipamento equipamento = equipamentoMapper.map(equipamentoDTO);
        equipamento.setId(id);
        equipamentoRepository.save(equipamento);
        return equipamentoMapper.map(equipamento);
    }

    public List<EquipamentoDTO> listarEquipamentos(){
        return equipamentoRepository.findAll().stream().map(equipamentoMapper::map).toList();
    }

    public EquipamentoDTO buscarEquipamentoId(Long id){
        return equipamentoMapper.map(equipamentoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID"+id+", não encontrado")));
    }

}
