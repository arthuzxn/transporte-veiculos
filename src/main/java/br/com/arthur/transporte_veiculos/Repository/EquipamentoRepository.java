package br.com.arthur.transporte_veiculos.Repository;

import br.com.arthur.transporte_veiculos.Entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Long, Equipamento> {
}
