package br.ecommercedigital.ecommerce.dto;

import java.math.BigDecimal;

public record PedidoRequestDTO(String status, BigDecimal total) {
}
