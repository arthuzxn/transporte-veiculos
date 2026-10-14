package br.com.arthur.transporte_veiculos.Controller;

import br.com.arthur.transporte_veiculos.DTO.Filial.FilialDTO;
import br.com.arthur.transporte_veiculos.Entity.Filial;
import br.com.arthur.transporte_veiculos.Service.FilialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filial")
@RequiredArgsConstructor
public class FilialController {

    private final FilialService filialService;

    @PostMapping
    public ResponseEntity<FilialDTO> criarFilial(@RequestBody FilialDTO filialDTO){
        FilialDTO filialCriada = filialService.criarFilial(filialDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(filialCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarFilial(@PathVariable Long id){
        filialService.deletarFilial(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<FilialDTO> atualizarFilial(@PathVariable Long id, @RequestBody FilialDTO filialDTO){
        FilialDTO FilialAtt = filialService.atualizarFilial(id,filialDTO);
        return ResponseEntity.ok().body(FilialAtt);
    }

    @GetMapping
    public ResponseEntity<List<FilialDTO>> listarDealers(){
        return ResponseEntity.ok().body(filialService.listarFiliais());
    }

    @GetMapping("{id}")
    public ResponseEntity<FilialDTO> buscarFilialId(@PathVariable Long id){
        FilialDTO filial = filialService.buscarFilialId(id);
        return ResponseEntity.ok().body(filial);
    }
}
