package br.com.arthur.transporte_veiculos.Controller;

import br.com.arthur.transporte_veiculos.DTO.Equipamento.EquipamentoDTO;
import br.com.arthur.transporte_veiculos.Entity.Equipamento;
import br.com.arthur.transporte_veiculos.Service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipamento")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<EquipamentoDTO> criarEquipamento(@RequestBody EquipamentoDTO equipamentoDTO){
        EquipamentoDTO equipamentoCriado = equipamentoService.criarEquipamento(equipamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EquipamentoDTO> atualizarEquipamento(@PathVariable Long id, @RequestBody EquipamentoDTO equipamentoDTO) {
        EquipamentoDTO equipamentoAtt = equipamentoService.atualizarEquipamento(id,equipamentoDTO);
        return ResponseEntity.ok().body(equipamentoAtt);
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoDTO>> listarEquipamentos(){
        return ResponseEntity.ok().body(equipamentoService.listarEquipamentos());
    }

    @GetMapping("{id}")
    public ResponseEntity<EquipamentoDTO> buscarEquipamentoId(@PathVariable Long id) {
        EquipamentoDTO equipamentoId = equipamentoService.buscarEquipamentoId(id);
        return ResponseEntity.ok().body(equipamentoId);
    }









}
