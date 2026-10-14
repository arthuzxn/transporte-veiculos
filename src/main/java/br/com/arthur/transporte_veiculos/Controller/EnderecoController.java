package br.com.arthur.transporte_veiculos.Controller;

import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoRequisicaoDTO;
import br.com.arthur.transporte_veiculos.DTO.Endereco.EnderecoRespostaDTO;
import br.com.arthur.transporte_veiculos.Entity.Endereco;
import br.com.arthur.transporte_veiculos.Service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoRespostaDTO> criarEndereco(@RequestBody EnderecoRequisicaoDTO requisicaoDTO){
        EnderecoRespostaDTO enderecoCriado = enderecoService.criarEndereco(requisicaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoCriado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id){
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoRespostaDTO> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRespostaDTO enderecoRespostaDTO){
        EnderecoRespostaDTO enderecoAtt = enderecoService.atualizarEndereco(id,enderecoRespostaDTO);
        return ResponseEntity.ok().body(enderecoAtt);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoRespostaDTO>> listarDealers(){
        return ResponseEntity.ok().body(enderecoService.listarEnderecos());
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoRespostaDTO> buscarEnderecoId(@PathVariable Long id){
        EnderecoRespostaDTO endereco = enderecoService.buscarEnderecoId(id);
        return ResponseEntity.ok().body(endereco);
    }
}
