package br.ecommercedigital.ecommerce.controller;


import br.ecommercedigital.ecommerce.dto.ItemRequestDTO;
import br.ecommercedigital.ecommerce.dto.ItemResponseDTO;
import br.ecommercedigital.ecommerce.model.Item;
import br.ecommercedigital.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/itens")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @PostMapping
    public void saveItem(@RequestBody ItemRequestDTO data){

        Item itemData = new Item(data);
        repository.save(itemData);
        return;
    }

    @GetMapping
    public List<ItemResponseDTO> getAll(){

        List<ItemResponseDTO> itemList = repository.findAll().stream().map(ItemResponseDTO::new).toList();
        return itemList;
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Item não foi encontrado"));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        Item item = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));

        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ItemRequestDTO dto){
        Item item = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item não foi encontrado"));

        item.setNome(dto.nome());
        item.setDescricao(dto.descricao());
        item.setEstoque(dto.estoque());
        item.setPreco(dto.preco());

        this.repository.save(item);
        return ResponseEntity.ok(item);
    }


}
