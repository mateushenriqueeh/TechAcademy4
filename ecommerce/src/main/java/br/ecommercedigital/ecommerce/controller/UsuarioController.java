package br.ecommercedigital.ecommerce.controller;


import br.ecommercedigital.ecommerce.dto.UsuarioRequestDTO;
import br.ecommercedigital.ecommerce.dto.UsuarioResponseDTO;
import br.ecommercedigital.ecommerce.model.Usuario;
import br.ecommercedigital.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void saveUsuario(@RequestBody UsuarioRequestDTO data){

        Usuario usuarioData = new Usuario(data);
        repository.save(usuarioData);
        return;

    }

    @GetMapping
    public List<UsuarioResponseDTO> getAll(){

        List<UsuarioResponseDTO> usuarioList = repository.findAll().stream().map(UsuarioResponseDTO::new).toList();
        return usuarioList;

    }

}
