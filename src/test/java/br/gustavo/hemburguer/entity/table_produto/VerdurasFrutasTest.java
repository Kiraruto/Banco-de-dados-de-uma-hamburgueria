package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.VerdurasFrutas;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class VerdurasFrutasTest {

    @Test
    public void testVerdurasFrutas() {
        Timestamp harvest = Timestamp.valueOf(LocalDateTime.now());
        Timestamp validity = Timestamp.valueOf(LocalDateTime.now());

        VerdurasFrutas verdura = new VerdurasFrutas(1L, "Alface", "Brazil", 2.0, harvest, 5.0, validity, new Produto(1L));

        assertEquals(Long.valueOf(1L), verdura.getId());
        assertEquals("Alface", verdura.getName());
        assertEquals("Brazil", verdura.getOrigin());
        assertEquals(Double.valueOf(2), verdura.getWeight());
        assertEquals(harvest, verdura.getHarvest_date());
        assertEquals(Double.valueOf(5), verdura.getPrice());
        assertEquals(validity, verdura.getValidity());
        assertEquals(Long.valueOf(1L), verdura.getProdutoId());
    }
}