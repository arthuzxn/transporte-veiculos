package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Motorista.MotoristaDTO;
import br.com.arthur.transporte_veiculos.Entity.Motorista;
import br.com.arthur.transporte_veiculos.Service.MotoristaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/motorista")
@RequiredArgsConstructor
public class MotoristaController {

    private final MotoristaService motoristaService;

    @PostMapping
    public ResponseEntity<MotoristaDTO> criarMotorista(@RequestBody MotoristaDTO motoristaDTO){
        MotoristaDTO motoristaCriado = motoristaService.criarMotorista(motoristaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarMotorista(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<MotoristaDTO> atualizarMotorista(@PathVariable Long id,@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motoristaAtt = motoristaService.atualizarMotorista(id, motoristaDTO);
        return ResponseEntity.ok().body(motoristaAtt);
    }
    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> listarMotoristas(){
        return ResponseEntity.ok().body(motoristaService.listarMotoristas());
    }

    @GetMapping("{id}")
    public ResponseEntity<MotoristaDTO> buscarMotoristaId(@PathVariable Long id){
        MotoristaDTO motorista = motoristaService.buscarMotoristaId(id);
        return ResponseEntity.ok().body(motorista);
    }

}
