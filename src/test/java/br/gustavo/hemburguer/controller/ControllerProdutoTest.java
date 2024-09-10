package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.controller.ControllerProduto;
import br.gustavo.hemburguer.entity.table_produto.Carne;
import br.gustavo.hemburguer.entity.table_produto.Paes;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.VerdurasFrutas;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOCarne;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOPaes;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOVerdurasFrutas;
import br.gustavo.hemburguer.entity.table_produto.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ControllerProdutoTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ControllerProduto controllerProduto;

    private DTOProduto dtoProduto;

    private final Timestamp timestampAll = Timestamp.valueOf(LocalDateTime.now());

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Carne carne = new Carne(1L, "Alcatra","Brazil", 5.5, 50, 80.5, timestampAll, timestampAll, new Produto(1L));
        Paes paes = new Paes(1L, "pão", "francês", 500, timestampAll, 0.20, timestampAll, new Produto(1L));
        VerdurasFrutas verdura = new VerdurasFrutas(1L, "Alface", "Brazil", 2.0, timestampAll, 5.0, timestampAll, new Produto(1L));

        List<Carne> carnes = Arrays.asList(carne);
        List<VerdurasFrutas> verdurasFrutas = Arrays.asList(verdura);

        dtoProduto = new DTOProduto("Mixed", DTOCarne.fromList(carnes), new DTOPaes(paes), DTOVerdurasFrutas.fromList(verdurasFrutas));
    }

    @Test
    public void adicionarProduto() {
        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).build();
        when(produtoService.save(dtoProduto)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerProduto.salvarProdutos(dtoProduto);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void verTodosProdutos() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(produtoService.verTodosProdutos()).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerProduto.getProdutos();

        assertEquals(expectedResponse, response);
    }

    @Test
    public void verProdutoPorId() {
        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(produtoService.verProdutoPorId(1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerProduto.getIdProduto(1L);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void atualizarProdutos() {
        Carne carne = new Carne(1L, "Picanha", "Argentina", 6.0, 55, 90.0, timestampAll, timestampAll, new Produto(1L));
        Paes paes = new Paes(1L, "Baguete", "Italiano", 350, timestampAll, 0.25, timestampAll, new Produto(1L));
        VerdurasFrutas verdura = new VerdurasFrutas(1L, "Cenoura", "Chile", 1.5, timestampAll, 3.0, timestampAll, new Produto(1L));

        List<Carne> carnes = Arrays.asList(carne);
        List<VerdurasFrutas> verdurasFrutas = Arrays.asList(verdura);

        dtoProduto = new DTOProduto("Mixed", DTOCarne.fromList(carnes), new DTOPaes(paes), DTOVerdurasFrutas.fromList(verdurasFrutas));

        ResponseEntity<?> expectedResponse = ResponseEntity.ok().build();
        when(produtoService.put(dtoProduto, 1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerProduto.putProduto(dtoProduto, 1L);

        assertEquals(expectedResponse, response);
    }

    @Test
    public void deleteProdutoId() {
        ResponseEntity<?> expectedResponse = ResponseEntity.noContent().build();
        when(produtoService.deletarProdutoPorId(1L)).thenReturn(expectedResponse);

        ResponseEntity<?> response = controllerProduto.deleteProduto(1L);

        assertEquals(expectedResponse, response);
    }

}