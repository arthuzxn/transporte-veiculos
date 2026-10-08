package br.com.arthur.transporte_veiculos.Controller;


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
    public ResponseEntity<Dealer> criarDealer(@RequestBody Dealer dealer){
        Dealer dealerCriado = dealerService.criarDealer(dealer);
        return ResponseEntity.status(HttpStatus.CREATED).body(dealerCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarDealer(@PathVariable Long id){
        dealerService.deletarDealer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Dealer> atualizarDealer(@PathVariable Long id, @RequestBody Dealer dealer){
        Dealer dealerAtt = dealerService.atualizarDealer(id,dealer);
        return ResponseEntity.ok().body(dealerAtt);
    }

    @GetMapping
    public ResponseEntity<List<Dealer>> listarDealers(){
        return ResponseEntity.ok().body(dealerService.listarDealers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Dealer> buscarDealerId(@PathVariable Long id){
        Dealer dealer = dealerService.buscarDealerId(id);
        return ResponseEntity.ok().body(dealer);
    }

}
