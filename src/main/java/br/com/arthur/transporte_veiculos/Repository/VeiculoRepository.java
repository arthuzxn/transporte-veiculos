package br.com.arthur.transporte_veiculos.Repository;

import br.com.arthur.transporte_veiculos.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Long, Veiculo> {
}
