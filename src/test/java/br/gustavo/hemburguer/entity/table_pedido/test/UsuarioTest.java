package br.gustavo.hemburguer.entity.table_pedido.test;

import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.enumclass.Role;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    private final Usuario usuarioUser = new Usuario(1L,"Gustavo", "gustavo@gmail.com", "123", "152", Role.ROLE_USER);

    @Test
    public void testUsuario() {
        assertEquals("Gustavo", usuarioUser.getName());
        assertEquals("gustavo@gmail.com", usuarioUser.getEmail());
        assertEquals("123", usuarioUser.getCpf());
        assertEquals("152", usuarioUser.getPassword());
        assertEquals(Role.ROLE_USER, usuarioUser.getRole());
    }

    @Test
    public void getPassword() {
        String password = "152";

        assertEquals(password, usuarioUser.getPassword());
    }

    @Test
    public void getUsername() {
        String username = "gustavo@gmail.com";

        assertEquals(username, usuarioUser.getUsername());
    }

    @Test
    public void setRoleUser() {
        Usuario usuarioModerator = new Usuario(1L,"Gustavo", "gustavo@gmail.com", "123", "152", Role.ROLE_USER);
        usuarioModerator.setRoleModerator();
        assertEquals(Role.ROLE_MODERATOR, usuarioModerator.getRole());
    }

    @Test
    public void setRoleModerator() {
        usuarioUser.setRoleModerator();
        assertEquals(Role.ROLE_MODERATOR, usuarioUser.getRole());
    }

}