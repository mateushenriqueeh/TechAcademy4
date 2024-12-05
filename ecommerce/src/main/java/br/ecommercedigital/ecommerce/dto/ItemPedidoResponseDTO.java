package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.ItemPedido;

public record ItemPedidoResponseDTO(Integer idPedido, Integer idItem, Integer quantidade, float precoUnitario) {

    public ItemPedidoResponseDTO(ItemPedido itemPedido) {
        this(itemPedido.getId().getIdPedido(),
                itemPedido.getId().getIdItem(),
                itemPedido.getQuantidade(),
                itemPedido.getPrecoUnitario());
    }
}
