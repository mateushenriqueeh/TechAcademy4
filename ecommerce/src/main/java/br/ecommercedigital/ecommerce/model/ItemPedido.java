package br.ecommercedigital.ecommerce.model;

import br.ecommercedigital.ecommerce.dto.ItemPedidoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoId id;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private float precoUnitario;

    public ItemPedido(ItemPedidoRequestDTO data) {
        this.id = new ItemPedidoId(data.idPedido(), data.idItem());
        this.quantidade = data.quantidade();
        this.precoUnitario = data.precoUnitario();
    }

    public ItemPedidoId getId() {
        return id;
    }

    public void setId(ItemPedidoId id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Embeddable
    public static class ItemPedidoId {

        @Column(name = "id_pedido")
        private Integer idPedido;

        @Column(name = "id_item")
        private Integer idItem;

        public ItemPedidoId() {
        }

        public ItemPedidoId(Integer idPedido, Integer idItem) {
            this.idPedido = idPedido;
            this.idItem = idItem;
        }

        public Integer getIdPedido() {
            return idPedido;
        }

        public void setIdPedido(Integer idPedido) {
            this.idPedido = idPedido;
        }

        public Integer getIdItem() {
            return idItem;
        }

        public void setIdItem(Integer idItem) {
            this.idItem = idItem;
        }
    }
}

