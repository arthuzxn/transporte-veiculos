package br.com.arthur.transporte_veiculos.Controller;


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
    public ResponseEntity<Transportadora> criarTransportadora(@RequestBody Transportadora transportadora){
        Transportadora transportadoraCriada = transportadoraService.criarTransportadora(transportadora);
        return ResponseEntity.status(HttpStatus.CREATED).body(transportadoraCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarTransportadora(@PathVariable Long id){
        transportadoraService.deletarTransportadora(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Transportadora> atualizarTransportadora(@PathVariable Long id,@RequestBody Transportadora transportadora){
        Transportadora transportadoraAtt = transportadoraService.atualizarTransportadora(id,transportadora);
        return ResponseEntity.ok().body(transportadoraAtt);
    }

    @GetMapping
    public ResponseEntity<List<Transportadora>> listarTransportadoras(){
        return ResponseEntity.ok().body(transportadoraService.listarTransportadoras());
    }

    @GetMapping("{id}")
    public ResponseEntity<Transportadora> buscarTransportadoraId(@PathVariable Long id){
        Transportadora transportadora = transportadoraService.buscarTransportadoraId(id);
        return ResponseEntity.ok().body(transportadora);
    }
}
