package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOCarne;
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

        DTOCarne dtoCarne = new DTOCarne("Alcatra","Brazil", 5.5, 50, 80.5, harvest, validity, 1L);

        Carne carne = new Carne(dtoCarne);

        assertEquals("Alcatra", carne.getName());
        assertEquals("Brazil", carne.getOrigin());
        assertEquals(Double.valueOf(5.5), carne.getFat_percentage());
        assertEquals(Integer.valueOf(50), carne.getWeight());
        assertEquals(Double.valueOf(80.5), carne.getPrice());
        assertEquals(harvest, carne.getHarvest_date());
        assertEquals(validity, carne.getValidity());
    }

}