package br.gustavo.hemburguer.entity.repository;

import br.gustavo.hemburguer.entity.table_pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findStatusById(Long id);
}
