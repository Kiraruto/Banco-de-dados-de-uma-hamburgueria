package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOUsuairo;
import br.gustavo.hemburguer.entity.table_pedido.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControllerUsuarioTest {


    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private ControllerUsuario controllerUsuario;

    private DTOUsuairo dtoUsuairo;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        dtoUsuairo = new DTOUsuairo("Gustavo", "gustavo@gmail.com", "123", "152");
    }

    @Test
    public void AdicionarUsuarioRole_USER() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(usuarioService.saveUser(dtoUsuairo)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerUsuario.criarUsuario(dtoUsuairo);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void AdicionarUsuarioRole_MODERATOR() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(usuarioService.saveModerator(dtoUsuairo)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerUsuario.criarUsuarioModerator(dtoUsuairo);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void verTodosUsuarios() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(usuarioService.verTodosUsuariosTable()).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerUsuario.verTodosUsuarios();

        assertEquals(expectedResponse, response);
    }

    @Test
    public void deletarPorId() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(usuarioService.deletarUsuarioPeloId(1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerUsuario.deletarUsuario(1L);

        assertEquals(expectedResponse, response);
    }
}