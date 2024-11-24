package br.ecommercedigital.ecommerce.repository;

import br.ecommercedigital.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
