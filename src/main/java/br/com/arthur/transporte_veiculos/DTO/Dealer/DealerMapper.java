package br.com.arthur.transporte_veiculos.DTO.Dealer;

import br.com.arthur.transporte_veiculos.Entity.Dealer;
import org.springframework.stereotype.Component;

@Component
public class DealerMapper {

    public Dealer map(DealerDTO dealerDTO){
        Dealer dealer = new Dealer();
        dealer.setCodigo_dealer(dealerDTO.getCodigo_dealer());
        dealer.setNome(dealerDTO.getNome());
        dealer.setEndereco(dealerDTO.getEndereco());
        dealer.setViagens(dealerDTO.getViagens());
        return dealer;
    }

    public DealerDTO map(Dealer dealer){
        DealerDTO dealerDTO = new DealerDTO();
        dealerDTO.setCodigo_dealer(dealer.getCodigo_dealer());
        dealerDTO.setNome(dealer.getNome());
        dealerDTO.setEndereco(dealer.getEndereco());
        dealerDTO.setViagens(dealer.getViagens());
        return dealerDTO;
    }
}
