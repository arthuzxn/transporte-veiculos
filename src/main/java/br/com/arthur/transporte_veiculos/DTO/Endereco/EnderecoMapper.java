package br.com.arthur.transporte_veiculos.DTO.Endereco;

import br.com.arthur.transporte_veiculos.DTO.ViaCep.ViaCepDTO;
import br.com.arthur.transporte_veiculos.Entity.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnderecoMapper {

    public Endereco map(EnderecoRequisicaoDTO requisicaoDTO){
        Endereco endereco = new Endereco();
        endereco.setCep(requisicaoDTO.getCep());
        endereco.setNumero(requisicaoDTO.getNumero());
        endereco.setComplemento(requisicaoDTO.getComplemento());
        return endereco;
    }

    public EnderecoRespostaDTO map(Endereco endereco){
        EnderecoRespostaDTO respostaDTO = new EnderecoRespostaDTO();
        respostaDTO.setId(endereco.getId());
        respostaDTO.setCep(endereco.getCep());
        respostaDTO.setLogradouro(endereco.getLogradouro());
        respostaDTO.setNumero(endereco.getNumero());
        respostaDTO.setComplemento(endereco.getComplemento());
        respostaDTO.setBairro(endereco.getBairro());
        respostaDTO.setCidade(endereco.getCidade());
        respostaDTO.setEstado(endereco.getEstado());
        respostaDTO.setPais(endereco.getPais());
        return respostaDTO;
    }

    public Endereco map (ViaCepDTO viaCepDTO, Short numero, String complemento){
        Endereco endereco = new Endereco();
        endereco.setCep(viaCepDTO.getCep());
        endereco.setLogradouro(viaCepDTO.getLogradouro());
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(viaCepDTO.getBairro());
        endereco.setCidade(viaCepDTO.getLocalidade());
        endereco.setEstado(viaCepDTO.getEstado());
        return endereco;
    }
}
