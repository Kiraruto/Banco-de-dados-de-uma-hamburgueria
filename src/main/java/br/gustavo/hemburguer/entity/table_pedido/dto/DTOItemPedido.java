package br.gustavo.hemburguer.entity.table_pedido.dto;

import br.gustavo.hemburguer.entity.table_pedido.ItemPedido;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record DTOItemPedido(@NotNull Long pedido_id,
                            @NotNull Long produto_id,
                            @NotNull Long usuario_id) {
    public static List<DTOItemPedido> fromList(List<ItemPedido> itemPedidoList) {
        return itemPedidoList.stream()
                .map(p -> new DTOItemPedido(p.getPedido_id(), p.getProduto_id(), p.getUsuario_id()))
                .collect(Collectors.toList());
    }
}
