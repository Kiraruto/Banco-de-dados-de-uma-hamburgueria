package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOItemPedido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemPedidoTest {

    @Test
    public void TestItemPedido() {

        DTOItemPedido dtoItemPedido = new DTOItemPedido(1L, 1L, 1L);

        ItemPedido itemPedido = new ItemPedido(dtoItemPedido);

        assertEquals(Long.valueOf(1L), itemPedido.getPedido_id());
        assertEquals(Long.valueOf(1L), itemPedido.getProduto_id());
        assertEquals(Long.valueOf(1L), itemPedido.getUsuario_id());
    }

}