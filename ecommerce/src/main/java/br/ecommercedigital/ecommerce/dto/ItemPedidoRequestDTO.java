package br.ecommercedigital.ecommerce.dto;

public record ItemPedidoRequestDTO(Integer idPedido, Integer idItem, Integer quantidade, float precoUnitario) {
}

