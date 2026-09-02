package br.com.arthur.transporte_veiculos.Repository;

import br.com.arthur.transporte_veiculos.Entity.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoristaRepository extends JpaRepository<Long, Motorista> {
}
