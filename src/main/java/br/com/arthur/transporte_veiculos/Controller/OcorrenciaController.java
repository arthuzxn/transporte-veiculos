package br.com.arthur.transporte_veiculos.Controller;

import br.com.arthur.transporte_veiculos.DTO.Ocorrencia.OcorrenciaDTO;
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
    public ResponseEntity<OcorrenciaDTO> criarOcorrencia(@RequestBody OcorrenciaDTO ocorrenciaDTO){
        OcorrenciaDTO ocorrenciaCriada = ocorrenciaService.criarOcorrencia(ocorrenciaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaCriada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarOcorrencia(@PathVariable Long id){
        ocorrenciaService.deletarOcorrencia(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<OcorrenciaDTO> atualizarOcorrencia(@PathVariable Long id, @RequestBody OcorrenciaDTO ocorrenciaDTO){
        OcorrenciaDTO ocorrenciaAtt = ocorrenciaService.atualizarOcorrencia(id,ocorrenciaDTO);
        return ResponseEntity.ok().body(ocorrenciaAtt);
    }

    @GetMapping
    public ResponseEntity<List<OcorrenciaDTO>> listarOcorrencias(){
        return ResponseEntity.ok().body(ocorrenciaService.listarOcorrencias());
    }

    @GetMapping("{id}")
    public ResponseEntity<OcorrenciaDTO> buscarOcorrenciaId(@PathVariable Long id){
        OcorrenciaDTO ocorrencia = ocorrenciaService.buscarOcorrenciaId(id);
        return ResponseEntity.ok().body(ocorrencia);
    }
}
