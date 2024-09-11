package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOEndereco;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnderecoTest {

    private final Endereco endereco =  new Endereco(1L, 1L, "Rua A", "123", "Cidade X", 12345, "Estado Y");

    @Test
    public void testEndereco() {
        assertEquals(Long.valueOf(1L), endereco.getId());
        assertEquals(Long.valueOf(1L), endereco.getUser());
        assertEquals("Rua A", endereco.getStreet());
        assertEquals("123", endereco.getNumber());
        assertEquals("Cidade X", endereco.getCity());
        assertEquals(Integer.valueOf(12345), endereco.getZip_code());
        assertEquals("Estado Y", endereco.getState());
    }

    @Test
    public void atualizarInformacoes() {
        endereco.atualizarInformacoes(new DTOEndereco(2L, "Rua B", "456", "Cidade Y", 67891, "Estado X"));

        assertEquals(Long.valueOf(2L), endereco.getUser());
        assertEquals("Rua B", endereco.getStreet());
        assertEquals("456", endereco.getNumber());
        assertEquals("Cidade Y", endereco.getCity());
        assertEquals(Integer.valueOf(67891), endereco.getZip_code());
        assertEquals("Estado X", endereco.getState());
    }
}