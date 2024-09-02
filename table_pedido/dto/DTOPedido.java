package br.gustavo.hemburguer.entity_tables.table_pedido.dto;

import br.gustavo.hemburguer.entity_tables.table_pedido.Pagamento;
import br.gustavo.hemburguer.entity_tables.table_pedido.Usuario;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

public record DTOPedido(@NotNull Timestamp date,
                        @NotNull Boolean status,
                        @NotNull List<Pagamento> pagamento,
                        @NotNull Usuario usuario_id) {
}
