package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.controller.ControllerPedido;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.PedidoService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ControllerPedidoTest {

    @Mock
    private PedidoService pedidoService;

    @InjectMocks
    private ControllerPedido controllerPedido;

    private DTOPedido dtoPedido;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        dtoPedido = new DTOPedido(1L);
    }

    @Test
    public void testAdicionarPedido() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(pedidoService.save(dtoPedido)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerPedido.postPedido(dtoPedido);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void setStatusTrue() {
        ResponseEntity<?> expectedReponse = ResponseEntity.ok().build();
        when(pedidoService.setStatusTrue(dtoPedido.usuario_id())).thenReturn(expectedReponse);

        ResponseEntity<?> response = controllerPedido.putPedido(dtoPedido.usuario_id());

        assertEquals(expectedReponse, response);
    }

    @Test
    public void deleteById() {
        ResponseEntity<?> expectedReponse = ResponseEntity.noContent().build();
        when(pedidoService.setStatusTrue(dtoPedido.usuario_id())).thenReturn(expectedReponse);

        ResponseEntity<?> response = controllerPedido.putPedido(dtoPedido.usuario_id());

        assertEquals(expectedReponse, response);
    }
}