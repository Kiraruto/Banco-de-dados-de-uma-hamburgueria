package br.gustavo.hemburguer.entity_tables.repository;

import br.gustavo.hemburguer.entity_tables.table_pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
