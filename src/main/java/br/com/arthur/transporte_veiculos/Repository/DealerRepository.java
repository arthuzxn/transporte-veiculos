package br.com.arthur.transporte_veiculos.Repository;

import br.com.arthur.transporte_veiculos.Entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Long, Dealer> {
}
