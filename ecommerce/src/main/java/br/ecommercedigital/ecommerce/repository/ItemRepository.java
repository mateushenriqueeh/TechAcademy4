package br.ecommercedigital.ecommerce.repository;


import br.ecommercedigital.ecommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {
}
