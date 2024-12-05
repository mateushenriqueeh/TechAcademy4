package br.ecommercedigital.ecommerce.repository;

import br.ecommercedigital.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}

