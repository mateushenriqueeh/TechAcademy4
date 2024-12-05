package br.ecommercedigital.ecommerce.dto;

import java.math.BigDecimal;

public record PagamentoRequestDTO(Integer idPedido, BigDecimal valorPago, String status) {
}

