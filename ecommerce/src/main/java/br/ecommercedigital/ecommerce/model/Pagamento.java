package br.ecommercedigital.ecommerce.model;

import br.ecommercedigital.ecommerce.dto.PagamentoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer id_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime data_pagamento;

    @Column(name = "valor_pago", nullable = false)
    private BigDecimal valor_pago;

    // Construtor para inicializar a partir do DTO de request
    public Pagamento(PagamentoRequestDTO data) {
        this.pedido = new Pedido();
        this.pedido.setId_pedido(data.idPedido());
        this.valor_pago = data.valorPago();
        this.data_pagamento = LocalDateTime.now();
    }

    public Integer getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LocalDateTime getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDateTime data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public BigDecimal getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(BigDecimal valor_pago) {
        this.valor_pago = valor_pago;
    }
}