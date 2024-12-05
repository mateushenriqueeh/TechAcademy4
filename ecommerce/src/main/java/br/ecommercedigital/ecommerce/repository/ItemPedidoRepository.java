package br.ecommercedigital.ecommerce.repository;

import br.ecommercedigital.ecommerce.model.ItemPedido;
import br.ecommercedigital.ecommerce.model.ItemPedido.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoId> {
}
