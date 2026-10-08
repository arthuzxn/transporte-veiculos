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

    public Endereco atualizarEndereco(Long id, Endereco endereco){
        if(!enderecoRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public Endereco buscarEnderecoId(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado"));
    }

}
