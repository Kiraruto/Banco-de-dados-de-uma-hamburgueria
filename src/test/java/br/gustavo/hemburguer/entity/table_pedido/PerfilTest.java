package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOUsuairo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfilTest {

    @Test
    public void testPerfil() {

        DTOUsuairo dtoPerfil = new DTOUsuairo("Gustavo", "071.596.470-41", "gustavo@gmail.com", "12345678");

        Perfil perfil = new Perfil( dtoPerfil);

        assertEquals("Gustavo", perfil.getName());
        assertEquals("gustavo@gmail.com", perfil.getEmail());
    }

}