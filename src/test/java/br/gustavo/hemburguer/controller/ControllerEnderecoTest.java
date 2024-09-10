package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.controller.ControllerEndereco;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOEndereco;
import br.gustavo.hemburguer.entity.table_pedido.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ControllerEnderecoTest {

    @Mock
    private EnderecoService enderecoService;

    @InjectMocks
    private ControllerEndereco controllerEndereco;

    private DTOEndereco dtoEndereco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dtoEndereco = new DTOEndereco( 1L, "Rua A", "123", "Cidade X", 12345, "Estado Y");
    }

    @Test
    void testAdicionarEndereco() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(enderecoService.save(dtoEndereco)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerEndereco.adicionarEndereco(dtoEndereco);

        assertEquals(expectedResponse, response);
    }

    @Test
    void testAtualizarEndereco() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(enderecoService.put(dtoEndereco, 1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerEndereco.atualizarEndereco(dtoEndereco, 1L);

        assertEquals(expectedResponse, response);
    }
}
