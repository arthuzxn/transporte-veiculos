package br.com.arthur.transporte_veiculos.Service;

import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoMapper;
import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoRequisicaoDTO;
import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoRespostaDTO;
import br.com.arthur.transporte_veiculos.Entity.Endereco;
import br.com.arthur.transporte_veiculos.Repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;
    private final EnderecoMapper enderecoMapper;


    public EnderecoRespostaDTO criarEndereco (EnderecoRequisicaoDTO requisicaoDTO){
        System.out.println("service "+requisicaoDTO.getCep());
        Endereco enderecoSalvo = viaCepService.buscarEndereco(requisicaoDTO);
        if(enderecoSalvo==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereco não encontrado");
        }else {
            enderecoRepository.save(enderecoSalvo);
            return enderecoMapper.map(enderecoSalvo);
        }
    }

    public void deletarEndereco(Long id){
        if(!enderecoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        enderecoRepository.deleteById(id);
    }

    public EnderecoRespostaDTO atualizarEndereco(Long id, EnderecoRespostaDTO enderecoRespostaDTO){
        if(!enderecoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        Endereco endereco = enderecoMapper.map(enderecoRespostaDTO);
        endereco.setId(id);
        enderecoRepository.save(endereco);
        return enderecoMapper.map(endereco);
    }

    public List<EnderecoRespostaDTO> listarEnderecos() {
        return enderecoRepository.findAll().stream().map(enderecoMapper::map).toList();
    }

    public EnderecoRespostaDTO buscarEnderecoId(Long id){
        return enderecoMapper.map(enderecoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado")));
    }

}
