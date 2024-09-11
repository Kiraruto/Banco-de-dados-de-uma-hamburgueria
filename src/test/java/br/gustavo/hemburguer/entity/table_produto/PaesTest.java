package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOPaes;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class PaesTest {

    @Test
    public void testPaes() {
        Timestamp manudacturing_date = Timestamp.valueOf(LocalDateTime.now());
        Timestamp validity = Timestamp.valueOf(LocalDateTime.now());

        DTOPaes dtoPaes = new DTOPaes("pão", "francês", 500, manudacturing_date, 0.20, validity, 1L);

        Paes paes = new Paes(dtoPaes);

        assertEquals("pão", paes.getName());
        assertEquals("francês", paes.getType_of_bread());
        assertEquals(Integer.valueOf(500), paes.getWeight());
        assertEquals(manudacturing_date, paes.getManufacturing_date());
        assertEquals(Double.valueOf(0.20), paes.getPrice());
        assertEquals(validity, paes.getValidity());
    }

}