package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.Entity.Viagem;
import br.com.arthur.transporte_veiculos.Service.ViagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagem")
@RequiredArgsConstructor
public class ViagemController {

    private final ViagemService viagemService;

    @PostMapping
    public ResponseEntity<Viagem> criarViagem(@RequestBody Viagem viagem){
        Viagem viagemCriada = viagemService.criarViagem(viagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarViagem(@PathVariable Long id){
        viagemService.deletarViagem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Viagem> atualizarViagem(@PathVariable Long id,@RequestBody Viagem viagem){
        Viagem viagemAtt = viagemService.atualizarViagem(id,viagem);
        return ResponseEntity.ok().body(viagemAtt);
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> listarViagens(){
        List<Viagem> viagemList = viagemService.listarViagens();
        return ResponseEntity.ok().body(viagemList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Viagem> buscarViagemId(@PathVariable Long id) {
        Viagem viagem = viagemService.buscarViagemId(id);
        return ResponseEntity.ok().body(viagem);
    }
}
