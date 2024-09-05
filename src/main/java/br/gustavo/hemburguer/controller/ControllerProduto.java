package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProdutoSemDTO;
import br.gustavo.hemburguer.entity.table_produto.repository.ProdutoRepository;
import br.gustavo.hemburguer.entity.table_produto.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        produtoService.save(dtoProduto);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getProdutos() {
        var saveGet = produtoRepository.findAll();

        List<DTOProdutoSemDTO> collect = DTOProdutoSemDTO.fromProdutoList(saveGet);

        return ResponseEntity.ok(collect);
    }

    @GetMapping("/{id}")
    public ResponseEntity getIdProduto(@PathVariable Long id) {
        var saveGet = produtoRepository.getReferenceById(id);

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Produto não Encontrado");
        }

        return ResponseEntity.ok(new DTOProdutoSemDTO(saveGet));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putProduto(@Valid @RequestBody DTOProduto dtoProduto, @PathVariable Long id) {

        return produtoService.put(dtoProduto, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduto(@PathVariable Long id) {

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (!produtoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
