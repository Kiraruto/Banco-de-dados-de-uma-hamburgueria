package br.gustavo.hemburguer.entity.repository;

import br.gustavo.hemburguer.entity.table_pedido.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
