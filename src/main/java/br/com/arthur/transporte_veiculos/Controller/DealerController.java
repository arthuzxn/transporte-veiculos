package br.com.arthur.transporte_veiculos.Controller;


import br.com.arthur.transporte_veiculos.DTO.Dealer.DealerDTO;
import br.com.arthur.transporte_veiculos.Entity.Dealer;
import br.com.arthur.transporte_veiculos.Service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealer")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;


    @PostMapping
    public ResponseEntity<DealerDTO> criarDealer(@RequestBody DealerDTO dealerDTO){
        DealerDTO dealerCriado = dealerService.criarDealer(dealerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealerCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarDealer(@PathVariable Long id){
        dealerService.deletarDealer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DealerDTO> atualizarDealer(@PathVariable Long id, @RequestBody DealerDTO dealerDTO){
        DealerDTO dealerAtt = dealerService.atualizarDealer(id,dealerDTO);
        return ResponseEntity.ok().body(dealerAtt);
    }

    @GetMapping
    public ResponseEntity<List<DealerDTO>> listarDealers(){
        return ResponseEntity.ok().body(dealerService.listarDealers());
    }

    @GetMapping("{id}")
    public ResponseEntity<DealerDTO> buscarDealerId(@PathVariable Long id){
        DealerDTO dealer = dealerService.buscarDealerId(id);
        return ResponseEntity.ok().body(dealer);
    }

}
