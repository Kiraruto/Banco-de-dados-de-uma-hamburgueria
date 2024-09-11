package br.gustavo.hemburguer.entity.table_pedido;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfilTest {

    @Test
    public void testPerfil() {

        Perfil perfil = new Perfil(1L, "Gustavo", "gustavo@gmail.com");

        assertEquals(Long.valueOf(1L), perfil.getId());
        assertEquals("Gustavo", perfil.getName());
        assertEquals("gustavo@gmail.com", perfil.getEmail());
    }

}