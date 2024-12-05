package br.ecommercedigital.ecommerce.controller;

import br.ecommercedigital.ecommerce.dto.ItemPedidoRequestDTO;
import br.ecommercedigital.ecommerce.dto.ItemPedidoResponseDTO;
import br.ecommercedigital.ecommerce.model.ItemPedido;
import br.ecommercedigital.ecommerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @PostMapping
    public void saveItemPedido(@RequestBody ItemPedidoRequestDTO data) {
        ItemPedido itemPedido = new ItemPedido(data);
        repository.save(itemPedido);
    }

    @GetMapping
    public List<ItemPedidoResponseDTO> getAll() {
        return repository.findAll().stream().map(ItemPedidoResponseDTO::new).toList();
    }

    @GetMapping("/{idPedido}/{idItem}")
    public ItemPedido findById(@PathVariable Integer idPedido, @PathVariable Integer idItem) {
        return repository.findById(new ItemPedido.ItemPedidoId(idPedido, idItem))
                .orElseThrow(() -> new IllegalArgumentException("ItemPedido não encontrado"));
    }

    @DeleteMapping("/{idPedido}/{idItem}")
    public ResponseEntity<Object> delete(@PathVariable Integer idPedido, @PathVariable Integer idItem) {
        ItemPedido itemPedido = repository.findById(new ItemPedido.ItemPedidoId(idPedido, idItem))
                .orElseThrow(() -> new IllegalArgumentException("ItemPedido não encontrado"));
        repository.delete(itemPedido);
        return ResponseEntity.noContent().build();
    }
}
