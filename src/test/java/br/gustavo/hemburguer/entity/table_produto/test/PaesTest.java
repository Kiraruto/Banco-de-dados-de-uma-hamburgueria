package br.gustavo.hemburguer.entity.table_produto.test;

import br.gustavo.hemburguer.entity.table_produto.Paes;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PaesTest {

    @Test
    public void testPaes() {
        Timestamp manudacturing_date = Timestamp.valueOf(LocalDateTime.now());
        Timestamp validity = Timestamp.valueOf(LocalDateTime.now());

        Paes paes = new Paes(1L, "pão", "frances", 500, manudacturing_date, 0.20, validity, new Produto(1L));

        assertEquals(Long.valueOf(1L), paes.getId());
        assertEquals("pão", paes.getName());
        assertEquals("frances", paes.getType_of_bread());
        assertEquals(Integer.valueOf(500), paes.getWeight());
        assertEquals(manudacturing_date, paes.getManufacturing_date());
        assertEquals(Double.valueOf(0.20), paes.getPrice(), 0.001);  // Para comparar doubles
        assertEquals(validity, paes.getValidity());
        assertEquals(Long.valueOf(1L), paes.getProdutoId());
    }

}