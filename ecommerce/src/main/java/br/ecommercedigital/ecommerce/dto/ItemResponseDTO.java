package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.Item;

public record ItemResponseDTO(Integer id_item, String nome, String descricao, float preco, Integer estoque) {

    public ItemResponseDTO(Item item){
        this(item.getId_item(), item.getNome(), item.getDescricao(), item.getPreco(), item.getEstoque());
    }
}
