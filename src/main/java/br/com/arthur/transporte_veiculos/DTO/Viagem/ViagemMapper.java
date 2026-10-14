package br.com.arthur.transporte_veiculos.DTO.Viagem;

import br.com.arthur.transporte_veiculos.Entity.Viagem;
import org.springframework.stereotype.Component;

@Component
public class ViagemMapper {

    public ViagemDTO mapRequisicao(Viagem viagem){
        ViagemDTO viagemDto = new ViagemDTO();
        viagemDto.setMotorista(viagem.getMotorista());
        viagemDto.setEquipamento(viagem.getEquipamento());
        viagemDto.setNumero_viagem(viagem.getNumero_viagem());
        viagemDto.setVeiculos(viagem.getVeiculos());
        viagemDto.setFilial(viagem.getFilial());
        viagemDto.setDealers(viagem.getDealers());
        return viagemDto;
    }

    public Viagem map(ViagemDTO viagemDto){
        Viagem viagem = new Viagem();
        viagem.setMotorista(viagemDto.getMotorista());
        viagem.setEquipamento(viagemDto.getEquipamento());
        viagem.setNumero_viagem(viagemDto.getNumero_viagem());
        viagem.setVeiculos(viagemDto.getVeiculos());
        viagem.setFilial(viagemDto.getFilial());
        return viagem;
    }

    public ViagemRespostaDTO mapResposta(Viagem viagem){
        ViagemRespostaDTO viagemRespostaDTO = new ViagemRespostaDTO();
        viagemRespostaDTO.setMotorista(viagem.getMotorista());
        viagemRespostaDTO.setEquipamento(viagem.getEquipamento());
        viagemRespostaDTO.setNumero_viagem(viagem.getNumero_viagem());
        viagemRespostaDTO.setVeiculosList(viagem.getVeiculos());
        viagemRespostaDTO.setFilial(viagem.getFilial());
        viagemRespostaDTO.setData_prevista_entrega(viagem.getData_prevista_entrega());
        viagemRespostaDTO.setDealers(viagem.getDealers());
        return viagemRespostaDTO;
    }

    public ViagemConsultaDTO mapConsulta(Viagem viagem){
        ViagemConsultaDTO viagemConsultaDTO = new ViagemConsultaDTO();
        viagemConsultaDTO.setMotorista(viagem.getMotorista());
        viagemConsultaDTO.setEquipamento(viagem.getEquipamento());
        viagemConsultaDTO.setNumero_viagem(viagem.getNumero_viagem());
        viagemConsultaDTO.setVeiculos(viagem.getVeiculos());
        viagemConsultaDTO.setFilial(viagem.getFilial());
        viagemConsultaDTO.setMomento_emissao(viagem.getMomento_emissao());
        viagemConsultaDTO.setData_prevista_entrega(viagem.getData_prevista_entrega());
        viagemConsultaDTO.setData_entrega(viagem.getData_entrega());
        viagemConsultaDTO.setDealers(viagem.getDealers());
        return  viagemConsultaDTO;
    }
}
