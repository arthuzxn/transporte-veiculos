package br.com.arthur.transporte_veiculos.Repository;

import br.com.arthur.transporte_veiculos.Entity.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora,Long> {
}
