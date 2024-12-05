package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.Pedido;

import java.math.BigDecimal;

public record PedidoResponseDTO(Integer id_pedido, BigDecimal total) {

    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId_pedido(), pedido.getTotal());
    }
}

