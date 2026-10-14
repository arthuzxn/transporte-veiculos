package br.com.arthur.transporte_veiculos.DTO.Filial;

import br.com.arthur.transporte_veiculos.Controller.FilialController;
import br.com.arthur.transporte_veiculos.Entity.Filial;
import org.springframework.stereotype.Component;

@Component
public class FilialMapper {

    public Filial map(FilialDTO filialDTO){
        Filial filial = new Filial();
        filial.setCodigoFilial(filialDTO.getCodigoFilial());
        filial.setEndereco(filialDTO.getEndereco());
        filial.setApelido(filialDTO.getApelido());
        filial.setViagens(filialDTO.getViagens());
        return filial;
    }

    public FilialDTO map(Filial filial){
        FilialDTO filialDTO = new FilialDTO();
        filialDTO.setCodigoFilial(filial.getCodigoFilial());
        filialDTO.setEndereco(filial.getEndereco());
        filialDTO.setApelido(filial.getApelido());
        filialDTO.setViagens(filial.getViagens());
        return filialDTO;
    }
}
