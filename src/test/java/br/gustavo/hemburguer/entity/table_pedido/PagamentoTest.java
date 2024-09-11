package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.Pagamento;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPagamento;
import org.junit.Test;

import static org.junit.Assert.*;

public class PagamentoTest {

    private final Pagamento pagamento = new Pagamento(1L, "pix", false, 1L);

    @Test
    public void testPagamento() {

        DTOPagamento dtoPagamento = new DTOPagamento("pix", 1L);

        Pagamento pagamentoTest = new Pagamento(dtoPagamento);

        assertEquals("pix", pagamentoTest.getPayment_method());
        assertEquals(Long.valueOf(1L), pagamentoTest.getPedido_id());
    }

    @Test
    public void statusTrue() {
        pagamento.statusTrue();

        assertEquals(true, pagamento.getStatus());
    }
}