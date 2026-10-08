package br.com.arthur.transporte_veiculos.Controller;

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
    public ResponseEntity<Filial> criarFilial(@RequestBody Filial filial){
        Filial filialCriada = filialService.criarFilial(filial);
        return ResponseEntity.status(HttpStatus.CREATED).body(filialCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarFilial(@PathVariable Long id){
        filialService.deletarFilial(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Filial> atualizarFilial(@PathVariable Long id, @RequestBody Filial filial){
        Filial FilialAtt = filialService.atualizarFilial(id,filial);
        return ResponseEntity.ok().body(FilialAtt);
    }

    @GetMapping
    public ResponseEntity<List<Filial>> listarDealers(){
        return ResponseEntity.ok().body(filialService.listarFiliais());
    }

    @GetMapping("{id}")
    public ResponseEntity<Filial> buscarFilialId(@PathVariable Long id){
        Filial filial = filialService.buscarFilialId(id);
        return ResponseEntity.ok().body(filial);
    }
}
