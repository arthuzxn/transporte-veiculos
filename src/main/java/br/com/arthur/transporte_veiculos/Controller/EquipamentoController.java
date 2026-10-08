package br.com.arthur.transporte_veiculos.Controller;

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
    public ResponseEntity<Equipamento> criarEquipamento(@RequestBody Equipamento equipamento){
        Equipamento equipamentoCriado = equipamentoService.criarEquipamento(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipamentoCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarEquipamento(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Equipamento> atualizarEquipamento(@PathVariable Long id, @RequestBody Equipamento equipamento) {
        Equipamento equipamentoAtt = equipamentoService.atualizarEquipamento(id,equipamento);
        return ResponseEntity.ok().body(equipamentoAtt);
    }

    @GetMapping
    public ResponseEntity<List<Equipamento>> listarEquipamentos(){
        return ResponseEntity.ok().body(equipamentoService.listarEquipamentos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Equipamento> buscarEquipamentoId(@PathVariable Long id) {
        Equipamento equipamentoId = equipamentoService.buscarEquipamentoId(id);
        return ResponseEntity.ok().body(equipamentoId);
    }









}
