package br.ecommercedigital.ecommerce.controller;

import br.ecommercedigital.ecommerce.dto.PagamentoRequestDTO;
import br.ecommercedigital.ecommerce.dto.PagamentoResponseDTO;
import br.ecommercedigital.ecommerce.model.Pagamento;
import br.ecommercedigital.ecommerce.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pagamentos")
public class  PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    @PostMapping
    public void savePagamento(@RequestBody PagamentoRequestDTO data) {
        Pagamento pagamento = new Pagamento(data);
        repository.save(pagamento);
    }

    @GetMapping
    public List<PagamentoResponseDTO> getAll() {
        return repository.findAll().stream().map(PagamentoResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Pagamento findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Pagamento pagamento = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
        repository.delete(pagamento);
        return ResponseEntity.noContent().build();
    }
}
