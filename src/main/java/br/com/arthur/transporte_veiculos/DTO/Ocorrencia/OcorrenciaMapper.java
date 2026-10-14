package br.com.arthur.transporte_veiculos.DTO.Ocorrencia;

import br.com.arthur.transporte_veiculos.Entity.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaMapper {

    public Ocorrencia map(OcorrenciaDTO ocorrenciaDTO){
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(ocorrenciaDTO.getDescricao());
        ocorrencia.setVeiculo(ocorrenciaDTO.getVeiculo());
        return ocorrencia;
    }

    public static OcorrenciaDTO map(Ocorrencia ocorrencia){
        OcorrenciaDTO ocorrenciaDTO = new OcorrenciaDTO();
        ocorrenciaDTO.setDescricao(ocorrencia.getDescricao());
        ocorrenciaDTO.setVeiculo(ocorrencia.getVeiculo());
        return ocorrenciaDTO;
    }
}
