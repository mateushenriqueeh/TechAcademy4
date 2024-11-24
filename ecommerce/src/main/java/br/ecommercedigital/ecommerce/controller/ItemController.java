package br.ecommercedigital.ecommerce.controller;


import br.ecommercedigital.ecommerce.dto.ItemRequestDTO;
import br.ecommercedigital.ecommerce.dto.ItemResponseDTO;
import br.ecommercedigital.ecommerce.model.Item;
import br.ecommercedigital.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itens")
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

}
