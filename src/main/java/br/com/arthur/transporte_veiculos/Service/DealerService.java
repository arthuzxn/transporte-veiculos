package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Dealer.DealerDTO;
import br.com.arthur.transporte_veiculos.DTO.Dealer.DealerMapper;
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
    private final DealerMapper dealerMapper;

    public DealerDTO criarDealer(DealerDTO dealerDTO){
        Dealer dealerSalvo = dealerMapper.map(dealerDTO);
        dealerRepository.save(dealerSalvo);
        return dealerMapper.map(dealerSalvo);
    }

    public void deletarDealer(Long id){
        if(!dealerRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        dealerRepository.deleteById(id);
    }

    public DealerDTO atualizarDealer(Long id,DealerDTO dealerDTO){
        if(!dealerRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        Dealer dealer = dealerMapper.map(dealerDTO);
        dealer.setId(id);
        dealerRepository.save(dealer);
        return dealerMapper.map(dealer);
    }

    public List<DealerDTO> listarDealers(){
        return dealerRepository.findAll().stream().map(dealerMapper::map).toList();
    }

    public DealerDTO buscarDealerId(Long id){
        return dealerMapper.map(dealerRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id "+id+", não encontrado")));
    }
}
