package br.com.arthur.transporte_veiculos.Service;


import br.com.arthur.transporte_veiculos.DTO.Viagem.*;
import br.com.arthur.transporte_veiculos.Entity.Viagem;
import br.com.arthur.transporte_veiculos.Repository.ViagemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.arthur.transporte_veiculos.Entity.Viagem.MAX_VEICULOS;

@Service
@RequiredArgsConstructor
public class ViagemService {

    private final ViagemRepository viagemRepository;
    private final MotoristaService motoristaService;
    private final VeiculoService veiculoService;
    private final ViagemMapper viagemMapper;

    public void validarViagem(Viagem viagem){
        if(!motoristaService.motoristaAtivo(viagem.getMotorista().getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Motorista escolhido para a viagem está BLOQUEADO");
        }

        if(viagem.getVeiculos() == null || viagem.getVeiculos().isEmpty()){
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

        if(viagem.getVeiculos().size() > MAX_VEICULOS ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"O LIMITE MÁXIMO DE VEICULOS TRANSPORTADOS PERMITIDO É "+ MAX_VEICULOS);
        }
    }

    public ViagemRespostaDTO criarViagem(ViagemDTO viagemDTO){
        Viagem viagem = viagemMapper.map(viagemDTO);
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        viagem.setMomento_emissao(dataHoraAgora);
        viagem.setData_prevista_entrega(dataHoraAgora.toLocalDate().plusDays(5)); // TESTE, POSTERIORMENTE SERÁ POR API
        validarViagem(viagem);
        Viagem viagemSalva = viagemRepository.save(viagem);
        veiculoService.embarcandoVeiculo(viagemSalva,viagem.getVeiculos());
        return viagemMapper.mapResposta(viagemSalva);
    }

    public void deletarViagem(Long id){
        if(!viagemRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado");
        }
        viagemRepository.deleteById(id);
    }

    public List<ViagemConsultaDTO> listarViagens(){
        return viagemRepository.findAll().stream().map(viagemMapper::mapConsulta).toList();
    }

    public ViagemConsultaDTO buscarViagemId(Long id){
        return viagemMapper.mapConsulta(viagemRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado")));
    }

    public void finalizarViagem(Long id, FinalizarViagemRequisicaoDTO finalizarViagemRequisicaoDTO){
        Viagem viagem = viagemRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID "+id+", não encontrado"));
        if(viagem.getData_entrega() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Viagem já foi finalizada");
        }
        veiculoService.veiculoEntregue(viagem);
        viagem.setData_entrega(finalizarViagemRequisicaoDTO.getData_entrega());
        viagemRepository.save(viagem);
    }

}
