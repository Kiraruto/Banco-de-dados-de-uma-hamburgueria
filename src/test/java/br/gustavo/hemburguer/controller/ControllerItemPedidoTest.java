package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.controller.ControllerItemPedido;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOItemPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.ItemPedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControllerItemPedidoTest {

    @Mock
    private ItemPedidoService itemPedidoService;

    @InjectMocks
    private ControllerItemPedido controllerItemPedido;

    private DTOItemPedido dtoItemPedido;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dtoItemPedido = new DTOItemPedido(1L, 1L, 1L);
    }

    @Test
    public void adicionarItemPedido() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(itemPedidoService.save(dtoItemPedido)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerItemPedido.postItemPedido(dtoItemPedido);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void puxarTodosOsItensPedidos() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(itemPedidoService.get()).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerItemPedido.getItensPedido();

        assertEquals(expectedResponse, response);
    }

}