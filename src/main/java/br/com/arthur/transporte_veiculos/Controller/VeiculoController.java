package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Veiculo.VeiculoDTO;
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
    public ResponseEntity<VeiculoDTO> criarVeiculo(@RequestBody VeiculoDTO veiculoDTO){
        VeiculoDTO VeiculoCriado = veiculoService.criarVeiculo(veiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(VeiculoCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO){
        VeiculoDTO veiculoAtt = veiculoService.atualizarVeiculo(id,veiculoDTO);
        return ResponseEntity.ok().body(veiculoAtt);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos(){
        return ResponseEntity.ok().body(veiculoService.listarVeiculos());
    }

    @GetMapping("{id}")
    public ResponseEntity<VeiculoDTO> buscarVeiculoId(@PathVariable Long id){
        VeiculoDTO veiculo = veiculoService.buscarVeiculoId(id);
        return ResponseEntity.ok().body(veiculo);
    }
}
