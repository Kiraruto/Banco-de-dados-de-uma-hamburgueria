package br.gustavo.hemburguer.entity_tables.table_produto.repository;

import br.gustavo.hemburguer.entity_tables.table_produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
