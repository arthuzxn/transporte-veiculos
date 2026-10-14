package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Viagem.FinalizarViagemRequisicaoDTO;
import br.com.arthur.transporte_veiculos.DTO.Viagem.ViagemConsultaDTO;
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

    @GetMapping
    public ResponseEntity<List<ViagemConsultaDTO>> listarViagens(){
        List<ViagemConsultaDTO> viagemList = viagemService.listarViagens();
        return ResponseEntity.ok().body(viagemList);
    }

    @GetMapping("{id}")
    public ResponseEntity<ViagemConsultaDTO> buscarViagemId(@PathVariable Long id) {
        ViagemConsultaDTO viagem = viagemService.buscarViagemId(id);
        return ResponseEntity.ok().body(viagem);
    }

    @PutMapping("/finalizar-viagem/{id}")
    public ResponseEntity<String> finalizarViagem(@PathVariable Long id, @RequestBody FinalizarViagemRequisicaoDTO finalizarViagemRequisicaoDTO){
        viagemService.finalizarViagem(id, finalizarViagemRequisicaoDTO);
        return ResponseEntity.noContent().build();
    }
}
