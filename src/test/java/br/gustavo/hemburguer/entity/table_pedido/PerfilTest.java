package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.Perfil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfilTest {

    @Test
    public void testPerfil() {

        Perfil perfil = new Perfil(1L, "Gustavo", "gustavo@gmail.com");

        assertEquals(Long.valueOf(1L), perfil.getId());
        assertEquals("Gustavo", perfil.getName());
        assertEquals("gustavo@gmail.com", perfil.getEmail());
    }

}