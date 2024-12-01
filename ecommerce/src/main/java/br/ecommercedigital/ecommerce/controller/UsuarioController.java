package br.ecommercedigital.ecommerce.controller;


import br.ecommercedigital.ecommerce.dto.ItemRequestDTO;
import br.ecommercedigital.ecommerce.dto.UsuarioRequestDTO;
import br.ecommercedigital.ecommerce.dto.UsuarioResponseDTO;
import br.ecommercedigital.ecommerce.model.Item;
import br.ecommercedigital.ecommerce.model.Usuario;
import br.ecommercedigital.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")

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
    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));

        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody UsuarioRequestDTO dto){
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}
