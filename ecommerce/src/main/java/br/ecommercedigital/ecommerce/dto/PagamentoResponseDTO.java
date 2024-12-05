package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.Pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponseDTO(Integer idPagamento, Integer idPedido, LocalDateTime dataPagamento, BigDecimal valorPago) {

    public PagamentoResponseDTO(Pagamento pagamento) {
        this(pagamento.getId_pagamento(),
                pagamento.getPedido().getId_pedido(),
                pagamento.getData_pagamento(),
                pagamento.getValor_pago());
    }
}