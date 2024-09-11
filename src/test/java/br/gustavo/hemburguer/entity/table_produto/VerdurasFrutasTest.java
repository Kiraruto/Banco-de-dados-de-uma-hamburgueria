package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOVerdurasFrutas;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class VerdurasFrutasTest {

    @Test
    public void testVerdurasFrutas() {
        Timestamp harvest = Timestamp.valueOf(LocalDateTime.now());
        Timestamp validity = Timestamp.valueOf(LocalDateTime.now());

        DTOVerdurasFrutas dtoVerduraFruta = new DTOVerdurasFrutas("Alface", "Brazil", 2.0, harvest, 5.0, validity,1L);

        VerdurasFrutas verdura = new VerdurasFrutas(dtoVerduraFruta);

        assertEquals("Alface", verdura.getName());
        assertEquals("Brazil", verdura.getOrigin());
        assertEquals(Double.valueOf(2), verdura.getWeight());
        assertEquals(harvest, verdura.getHarvest_date());
        assertEquals(Double.valueOf(5), verdura.getPrice());
        assertEquals(validity, verdura.getValidity());
    }
}