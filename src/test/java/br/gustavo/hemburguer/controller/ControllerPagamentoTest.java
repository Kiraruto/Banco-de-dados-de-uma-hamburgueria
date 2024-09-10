package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.controller.ControllerPagamento;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPagamento;
import br.gustavo.hemburguer.entity.table_pedido.service.PagamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControllerPagamentoTest {

    @Mock
    private PagamentoService pagamentoService;

    @InjectMocks
    private ControllerPagamento controllerPagamento;

    private DTOPagamento dtoPagamento;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        dtoPagamento = new DTOPagamento("pix", 1L);
    }

    @Test
    public void criarPagamento() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(pagamentoService.save(dtoPagamento)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerPagamento.postPagamento(dtoPagamento);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void colocarStatusTrue() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(pagamentoService.salvarTruePagamento(1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerPagamento.putPagamento(1L);

        assertEquals(expectedResponse, response);
    }
}