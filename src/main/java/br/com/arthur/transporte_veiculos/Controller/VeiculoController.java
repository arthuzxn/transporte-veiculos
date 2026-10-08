package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.Entity.Veiculo;
import br.com.arthur.transporte_veiculos.Service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo){
        Veiculo VeiculoCriado = veiculoService.criarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo){
        Veiculo veiculoAtt = veiculoService.atualizarVeiculo(id,veiculo);
        return ResponseEntity.ok().body(veiculoAtt);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarVeiculos(){
        return ResponseEntity.ok().body(veiculoService.listarVeiculos());
    }

    @GetMapping("{id}")
    public ResponseEntity<Veiculo> buscarVeiculoId(@PathVariable Long id){
        Veiculo veiculo = veiculoService.buscarVeiculoId(id);
        return ResponseEntity.ok().body(veiculo);
    }
}
