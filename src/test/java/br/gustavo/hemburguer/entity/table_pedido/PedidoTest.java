package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PedidoTest {

    private final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
    private final Pedido pedido = new Pedido(1L, timestamp,false, 1L);

    @Test
    public void testPedido() {

        DTOPedido dtoPedido = new DTOPedido(1L);

        Pedido pedidoTest = new Pedido(dtoPedido);

        assertEquals(Long.valueOf(1L), pedido.getUsuario_id());
    }

    @Test
    public void statusTrue() {
        pedido.statusTrue();

        assertEquals(true, pedido.getStatus());
    }

}