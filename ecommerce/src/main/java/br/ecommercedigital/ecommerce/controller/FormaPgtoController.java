package br.ecommercedigital.ecommerce.controller;

import br.ecommercedigital.ecommerce.dto.FormaPgtoRequestDTO;
import br.ecommercedigital.ecommerce.dto.FormaPgtoResponseDTO;
import br.ecommercedigital.ecommerce.model.FormaPgto;
import br.ecommercedigital.ecommerce.repository.FormaPgtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/formas-pgto")
public class FormaPgtoController {

    @Autowired
    private FormaPgtoRepository repository;

    @PostMapping
    public void saveFormaPgto(@RequestBody FormaPgtoRequestDTO data) {
        FormaPgto formaPgto = new FormaPgto();
        formaPgto.setDescricao(data.descricao());
        repository.save(formaPgto);
    }

    @GetMapping
    public List<FormaPgtoResponseDTO> getAll() {
        return repository.findAll().stream().map(FormaPgtoResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public FormaPgto findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        FormaPgto formaPgto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada"));
        repository.delete(formaPgto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody FormaPgtoRequestDTO dto) {
        FormaPgto formaPgto = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Forma de pagamento não encontrada"));
        formaPgto.setDescricao(dto.descricao());
        repository.save(formaPgto);
        return ResponseEntity.ok(formaPgto);
    }
}

