package br.com.arthur.transporte_veiculos.DTO.Endereco;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequisicaoDTO {
    private String cep;
    private Short numero;
    private String complemento;
}
