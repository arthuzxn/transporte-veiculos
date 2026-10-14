package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Transportadora.TransportadoraDTO;
import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import br.com.arthur.transporte_veiculos.Service.TransportadoraService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transportadora")
@RestController
@RequiredArgsConstructor
public class TransportadoraController {

    private final TransportadoraService transportadoraService;

    @PostMapping
    public ResponseEntity<TransportadoraDTO> criarTransportadora(@RequestBody TransportadoraDTO transportadoraDTO){
        TransportadoraDTO transportadoraCriada = transportadoraService.criarTransportadora(transportadoraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transportadoraCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarTransportadora(@PathVariable Long id){
        transportadoraService.deletarTransportadora(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<TransportadoraDTO> atualizarTransportadora(@PathVariable Long id,@RequestBody TransportadoraDTO transportadoraDTO){
        TransportadoraDTO transportadoraAtt = transportadoraService.atualizarTransportadora(id,transportadoraDTO);
        return ResponseEntity.ok().body(transportadoraAtt);
    }

    @GetMapping
    public ResponseEntity<List<TransportadoraDTO>> listarTransportadoras(){
        return ResponseEntity.ok().body(transportadoraService.listarTransportadoras());
    }

    @GetMapping("{id}")
    public ResponseEntity<TransportadoraDTO> buscarTransportadoraId(@PathVariable Long id){
        TransportadoraDTO transportadora = transportadoraService.buscarTransportadoraId(id);
        return ResponseEntity.ok().body(transportadora);
    }
}
