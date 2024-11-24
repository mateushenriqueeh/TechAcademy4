package br.ecommercedigital.ecommerce.dto;

import br.ecommercedigital.ecommerce.model.Usuario;

public record UsuarioResponseDTO(Integer id_usuario, String nome, String email, String senha ) {

    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId_usuario(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
