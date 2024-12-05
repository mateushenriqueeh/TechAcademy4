package br.ecommercedigital.ecommerce.repository;

import br.ecommercedigital.ecommerce.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}

