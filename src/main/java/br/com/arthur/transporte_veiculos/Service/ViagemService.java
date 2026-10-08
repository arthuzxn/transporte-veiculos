package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.Entity.Viagem;
import br.com.arthur.transporte_veiculos.Repository.ViagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ViagemService {

    private final ViagemRepository viagemRepository;
    private final MotoristaService motoristaService;
    private final VeiculoService veiculoService;

    public void validarViagem(Viagem viagem){

        if(!motoristaService.motoristaAtivo(viagem.getMotorista().getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Motorista escolhido para a viagem está BLOQUEADO");
        }

        if(viagem.getVeiculos().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Viagem sem nenhum veículo");
        }

        List<Viagem> viagens = viagemRepository.findAll();
        boolean validarViagemPendenteEquipamento = viagens.stream()
                .filter(viagemService -> viagemService.getEquipamento().getId().equals(viagem.getEquipamento().getId()))
                .anyMatch(viagemService -> viagemService.getData_entrega() == null);

        if(validarViagemPendenteEquipamento){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Equipamento está em viagem");
        }

        boolean validarViagemPendenteMotorista = viagens.stream()
                .filter(viagemService -> viagemService.getMotorista().getId().equals(viagem.getMotorista().getId()))
                .anyMatch(viagemService -> viagemService.getData_entrega() == null);

        if(validarViagemPendenteMotorista){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Motorista está em viagem");
        }

    }

    public Viagem criarViagem(Viagem viagem){
        validarViagem(viagem);
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        viagem.setMomento_emissao(dataHoraAgora);
        Viagem viagemSalva = viagemRepository.save(viagem);
        veiculoService.embarcandoVeiculo(viagemSalva,viagem.getVeiculos());
        return viagemSalva;
    }

    public void deletarViagem(Long id){
        if(!viagemRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        viagemRepository.deleteById(id);
    }

    public Viagem atualizarViagem(Long id, Viagem viagem){
        if(!viagemRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        viagem.setId(id);
        return viagemRepository.save(viagem);
    }

    public List<Viagem> listarViagens(){
        return viagemRepository.findAll();
    }

    public Viagem buscarViagemId(Long id){
        return viagemRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado"));
    }

}
