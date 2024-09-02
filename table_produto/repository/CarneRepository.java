package br.gustavo.hemburguer.entity_tables.table_produto.repository;

import br.gustavo.hemburguer.entity_tables.table_produto.Carne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarneRepository extends JpaRepository<Carne, Long> {
}
