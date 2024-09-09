package br.gustavo.hemburguer.entity.table_produto.test;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import br.gustavo.hemburguer.entity.table_produto.Paes;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.VerdurasFrutas;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOCarne;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOPaes;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOVerdurasFrutas;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoTest {

    private final  Timestamp timestampAll = Timestamp.valueOf(LocalDateTime.now());

    @Test
    public void testProduto() {

        Carne carne = new Carne(1L, "Alcatra","Brazil", 5.5, 50, 80.5, timestampAll, timestampAll, new Produto(1L));
        Paes paes = new Paes(1L, "pão", "francês", 500, timestampAll, 0.20, timestampAll, new Produto(1L));
        VerdurasFrutas verdura = new VerdurasFrutas(1L, "Alface", "Brazil", 2.0, timestampAll, 5.0, timestampAll, new Produto(1L));


        List<Carne> carnes = Arrays.asList(carne);
        List<VerdurasFrutas> verdurasFrutas = Arrays.asList(verdura);

        Produto produto = new Produto(1L, "Burguer", carnes, paes, verdurasFrutas);

        assertEquals(Long.valueOf(1L), produto.getId());
        assertEquals("Burguer", produto.getName());

        assertEquals(1, produto.getCarnes_id().size());
        assertEquals("Alcatra", produto.getCarnes_id().get(0).getName());

        assertEquals("pão", produto.getPaes_id().getName());

        assertEquals(1, produto.getVerdurasFrutas_id().size());
        assertEquals("Alface", produto.getVerdurasFrutas_id().get(0).getName());
    }

    private Produto produto;

    @Before
    public void setUp() {
        produto = new Produto(1L, "Burguer", new ArrayList<>(), null, new ArrayList<>());
    }

    @Test
    public void atualizarInformacoes() {
        DTOCarne dtoCarne = new DTOCarne("Alcatra","Brazil", 5.5, 50, 80.5, timestampAll, timestampAll, 1L);
        DTOPaes dtoPaes = new DTOPaes("pão", "francês", 500, timestampAll, 0.20, timestampAll, 1L);
        DTOVerdurasFrutas dtoVerduraFruta = new DTOVerdurasFrutas("Alface", "Brazil", 2.0, timestampAll, 5.0, timestampAll,1L);

        List<DTOCarne> dtoCarnes = List.of(dtoCarne);
        List<DTOVerdurasFrutas> dtoVerdurasFrutas = List.of(dtoVerduraFruta);

        DTOProduto dtoProduto = new DTOProduto("Burguer", dtoCarnes, dtoPaes, dtoVerdurasFrutas);

        produto.atualizarInformacoes(dtoProduto);

        assertEquals(1, produto.getCarnes_id().size());
        Carne carneAtualizada = produto.getCarnes_id().get(0);
        assertEquals("Alcatra", carneAtualizada.getName());
        assertEquals("Brazil", carneAtualizada.getOrigin());
        assertEquals(Double.valueOf(5.5), carneAtualizada.getFat_percentage());
        assertEquals(Integer.valueOf(50), carneAtualizada.getWeight());
        assertEquals(Double.valueOf(80.5), carneAtualizada.getPrice());
        assertEquals(timestampAll, carneAtualizada.getHarvest_date());
        assertEquals(timestampAll, carneAtualizada.getValidity());

        assertNotNull(produto.getPaes_id());
        Paes paesAtualizado = produto.getPaes_id();
        assertEquals("pão", paesAtualizado.getName());
        assertEquals("francês", paesAtualizado.getType_of_bread());
        assertEquals(Integer.valueOf(500), paesAtualizado.getWeight());
        assertEquals(Double.valueOf(0.20), paesAtualizado.getPrice());
        assertEquals(timestampAll, paesAtualizado.getValidity());
        assertEquals(timestampAll, paesAtualizado.getManufacturing_date());

        assertEquals(1, produto.getVerdurasFrutas_id().size());
        VerdurasFrutas verduraAtualizada = produto.getVerdurasFrutas_id().get(0);
        assertEquals("Alface", verduraAtualizada.getName());
        assertEquals("Brazil", verduraAtualizada.getOrigin());
        assertEquals(Double.valueOf(2.0), verduraAtualizada.getWeight());
        assertEquals(Double.valueOf(5.0), verduraAtualizada.getPrice());
        assertEquals(timestampAll, verduraAtualizada.getHarvest_date());
        assertEquals(timestampAll, verduraAtualizada.getValidity());
    }
}