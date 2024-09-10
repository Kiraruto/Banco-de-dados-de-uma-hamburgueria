package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.ItemPedido;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemPedidoTest {

    @Test
    public void TestItemPedido() {

        ItemPedido itemPedido = new ItemPedido(1L, 1L, 1L, 1L);

        assertEquals(Long.valueOf(1L), itemPedido.getId());
        assertEquals(Long.valueOf(1L), itemPedido.getPedido_id());
        assertEquals(Long.valueOf(1L), itemPedido.getProduto_id());
        assertEquals(Long.valueOf(1L), itemPedido.getUsuario_id());


    }

}