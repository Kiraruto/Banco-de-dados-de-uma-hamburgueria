package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOUsuairo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfilTest {

    @Test
    public void testPerfil() {

        DTOUsuairo dtoUsuairo = new DTOUsuairo("Gustavo", "123", "gustavo@gmail.com", "152");

        Perfil perfil = new Perfil(dtoUsuairo);

        assertEquals("Gustavo", perfil.getName());
        assertEquals("gustavo@gmail.com", perfil.getEmail());
    }

}