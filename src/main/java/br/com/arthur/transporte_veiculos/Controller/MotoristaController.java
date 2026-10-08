package br.com.arthur.transporte_veiculos.Controller;


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
    public ResponseEntity<Motorista> criarMotorista(@RequestBody Motorista motorista){
        Motorista motoristaCriado = motoristaService.criarMotorista(motorista);
        return ResponseEntity.status(HttpStatus.CREATED).body(motoristaCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarMotorista(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Motorista> atualizarMotorista(@PathVariable Long id,@RequestBody Motorista motorista) {
        Motorista motoristaAtt = motoristaService.atualizarMotorista(id, motorista);
        return ResponseEntity.ok().body(motoristaAtt);
    }
    @GetMapping
    public ResponseEntity<List<Motorista>> listarMotoristas(){
        return ResponseEntity.ok().body(motoristaService.listarMotoristas());
    }

    @GetMapping("{id}")
    public ResponseEntity<Motorista> buscarMotoristaId(@PathVariable Long id){
        Motorista motorista = motoristaService.buscarMotoristaId(id);
        return ResponseEntity.ok().body(motorista);
    }

}
