package br.ecommercedigital.ecommerce.controller;

import br.ecommercedigital.ecommerce.dto.PedidoRequestDTO;
import br.ecommercedigital.ecommerce.dto.PedidoResponseDTO;
import br.ecommercedigital.ecommerce.model.Pedido;
import br.ecommercedigital.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping
    public void savePedido(@RequestBody PedidoRequestDTO data) {
        Pedido pedido = new Pedido();
        pedido.setTotal(data.total());
        repository.save(pedido);
    }

    @GetMapping
    public List<PedidoResponseDTO> getAll() {
        return repository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Pedido findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        repository.delete(pedido);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody PedidoRequestDTO dto) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        pedido.setTotal(dto.total());
        repository.save(pedido);
        return ResponseEntity.ok(pedido);
    }
}
