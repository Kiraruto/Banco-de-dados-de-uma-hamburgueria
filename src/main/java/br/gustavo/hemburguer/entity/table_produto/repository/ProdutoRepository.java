package br.gustavo.hemburguer.entity.table_produto.repository;

import br.gustavo.hemburguer.entity.table_produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
