package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.FormaPgto;

public record FormaPgtoResponseDTO(Integer id_forma_pgto, String descricao) {

    public FormaPgtoResponseDTO(FormaPgto formaPgto) {
        this(formaPgto.getId_forma_pgto(), formaPgto.getDescricao());
    }
}

