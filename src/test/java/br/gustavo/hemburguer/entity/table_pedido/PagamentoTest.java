package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.Pagamento;
import org.junit.Test;

import static org.junit.Assert.*;

public class PagamentoTest {

    private final Pagamento pagamento = new Pagamento(1L, "pix", false, 1L);

    @Test
    public void testPagamento() {
        assertEquals(Long.valueOf(1L), pagamento.getId());
        assertEquals("pix", pagamento.getPayment_method());
        assertEquals(false, pagamento.getStatus());
        assertEquals(Long.valueOf(1L), pagamento.getPedido_id());
    }

    @Test
    public void statusTrue() {
        pagamento.statusTrue();

        assertEquals(true, pagamento.getStatus());
    }
}