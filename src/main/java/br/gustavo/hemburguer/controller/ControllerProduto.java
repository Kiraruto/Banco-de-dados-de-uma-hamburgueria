package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity salvarProdutos(@RequestBody @Valid DTOProduto dtoProduto) {

        produtoService.save(dtoProduto);

        return ResponseEntity.ok().build();
    }
}
