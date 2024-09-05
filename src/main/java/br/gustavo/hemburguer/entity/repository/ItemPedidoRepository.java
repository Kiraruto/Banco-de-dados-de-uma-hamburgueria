package br.gustavo.hemburguer.entity.repository;

import br.gustavo.hemburguer.entity.table_pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
