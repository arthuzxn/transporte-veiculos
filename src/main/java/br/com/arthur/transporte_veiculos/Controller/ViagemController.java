package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Viagem.FinalizarViagemRequisicaoDTO;
import br.com.arthur.transporte_veiculos.DTO.Viagem.ViagemDTO;
import br.com.arthur.transporte_veiculos.DTO.Viagem.ViagemRespostaDTO;
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
    public ResponseEntity<ViagemRespostaDTO> criarViagem(@RequestBody ViagemDTO viagemDto){
        ViagemRespostaDTO viagemCriada = viagemService.criarViagem(viagemDto);
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

    @PutMapping("/finalizar-viagem/{id}")
    public ResponseEntity<String> finalizarViagem(@PathVariable Long id, @RequestBody FinalizarViagemRequisicaoDTO finalizarViagemRequisicaoDTO){
        viagemService.finalizarViagem(id, finalizarViagemRequisicaoDTO);
        return ResponseEntity.noContent().build();
    }
}
