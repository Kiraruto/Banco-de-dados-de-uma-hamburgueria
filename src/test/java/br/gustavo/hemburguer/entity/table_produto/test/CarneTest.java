package br.gustavo.hemburguer.entity.table_produto.test;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class CarneTest {

    @Test
    public void testCarne() {
        Timestamp harvest = Timestamp.valueOf(LocalDateTime.now());
        Timestamp validity = Timestamp.valueOf(LocalDateTime.now());

        Carne carne = new Carne(1L, "Alcatra","Brazil", 5.5, 50, 80.5, harvest, validity, new Produto(1L));

        assertEquals(Long.valueOf(1L), carne.getId());
        assertEquals("Alcatra", carne.getName());
        assertEquals("Brazil", carne.getOrigin());
        assertEquals(Double.valueOf(5.5), carne.getFat_percentage());
        assertEquals(Integer.valueOf(50), carne.getWeight());
        assertEquals(Double.valueOf(80.5), carne.getPrice());
        assertEquals(harvest, carne.getHarvest_date());
        assertEquals(validity, carne.getValidity());
        assertEquals(Long.valueOf(1L), carne.getProdutoId());
    }

}