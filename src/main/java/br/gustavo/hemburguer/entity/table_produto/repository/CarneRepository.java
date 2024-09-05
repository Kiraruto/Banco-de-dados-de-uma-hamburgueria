package br.gustavo.hemburguer.entity.table_produto.repository;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarneRepository extends JpaRepository<Carne, Long> {
}
