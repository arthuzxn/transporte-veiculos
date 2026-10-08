package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoMapper;
import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoRequisicaoDTO;
import br.com.arthur.transporte_veiculos.DTO.ViaCep.ViaCepDTO;
import br.com.arthur.transporte_veiculos.Entity.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ViaCepService {

    private final WebClient webClient;
    private final EnderecoMapper enderecoMapper;

    public Endereco buscarEndereco(EnderecoRequisicaoDTO requisicaoDTO){
        System.out.println("via cep "+requisicaoDTO.getCep());
        return webClient.get()
                .uri("/{cep}/json/", requisicaoDTO.getCep())
                .retrieve()
                .bodyToMono(ViaCepDTO.class)
                .map(viaCepDTO -> enderecoMapper.map(viaCepDTO, requisicaoDTO.getNumero(), requisicaoDTO.getComplemento()))
                .block();
    }
}
