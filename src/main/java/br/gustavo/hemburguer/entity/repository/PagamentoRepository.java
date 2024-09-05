package br.gustavo.hemburguer.entity.repository;

import br.gustavo.hemburguer.entity.table_pedido.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findStatusById(Long id);
}
