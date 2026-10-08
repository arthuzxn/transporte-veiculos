package br.com.arthur.transporte_veiculos.Controller;

import br.com.arthur.transporte_veiculos.Entity.Ocorrencia;
import br.com.arthur.transporte_veiculos.Service.OcorrenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
@RequiredArgsConstructor
public class OcorrenciaController {

    private final OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> criarOcorrencia(@RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaCriada = ocorrenciaService.criarOcorrencia(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarOcorrencia(@PathVariable Long id){
        ocorrenciaService.deletarOcorrencia(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Ocorrencia> atualizarOcorrencia(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia){
        Ocorrencia ocorrenciaAtt = ocorrenciaService.atualizarOcorrencia(id,ocorrencia);
        return ResponseEntity.ok().body(ocorrenciaAtt);
    }

    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listarOcorrencias(){
        return ResponseEntity.ok().body(ocorrenciaService.listarOcorrencias());
    }

    @GetMapping("{id}")
    public ResponseEntity<Ocorrencia> buscarOcorrenciaId(@PathVariable Long id){
        Ocorrencia ocorrencia = ocorrenciaService.buscarOcorrenciaId(id);
        return ResponseEntity.ok().body(ocorrencia);
    }
}
