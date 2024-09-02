package br.gustavo.hemburguer.entity_tables.repository;

import br.gustavo.hemburguer.entity_tables.table_pedido.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
