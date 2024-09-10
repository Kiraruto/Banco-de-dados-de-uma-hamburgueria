package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.repository.ProdutoRepository;
import br.gustavo.hemburguer.entity.table_produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity salvarProdutos(@RequestBody @Valid DTOProduto dtoProduto) {

        return produtoService.save(dtoProduto);
    }

    @GetMapping
    public ResponseEntity getProdutos() {

        return produtoService.verTodosProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity getIdProduto(@PathVariable Long id) {

        return produtoService.verProdutoPorId(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putProduto(@Valid @RequestBody DTOProduto dtoProduto, @PathVariable Long id) {

        return produtoService.put(dtoProduto, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable Long id) {

        return produtoService.deletarProdutoPorId(id);
    }

}
