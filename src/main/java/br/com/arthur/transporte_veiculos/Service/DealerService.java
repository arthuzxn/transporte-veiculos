package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.Entity.Dealer;
import br.com.arthur.transporte_veiculos.Repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;

    public Dealer criarDealer(Dealer dealer){
        return dealerRepository.save(dealer);
    }

    public void deletarDealer(Long id){
        if(!dealerRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        dealerRepository.deleteById(id);
    }

    public Dealer atualizarDealer(Long id,Dealer dealer){
        if(!dealerRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        dealer.setId(id);
        return dealerRepository.save(dealer);
    }

    public List<Dealer> listarDealers(){
        return dealerRepository.findAll();
    }

    public Dealer buscarDealerId(Long id){
        return dealerRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id "+id+", não encontrado"));
    }
}
