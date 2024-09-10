package br.gustavo.hemburguer.entity.table_produto.service;

import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProdutoSemDTO;
import br.gustavo.hemburguer.entity.table_produto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ResponseEntity save(DTOProduto dtoProduto) {
        produtoRepository.save(new Produto(dtoProduto));

        return ResponseEntity.ok().build();
    }

    public ResponseEntity put(@Valid DTOProduto dtoProduto, Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Produto não Encontrado");
        }

        var produto = produtoRepository.getReferenceById(id);
        produto.atualizarInformacoes(dtoProduto);

        return ResponseEntity.ok(new DTOProdutoSemDTO(produto));
    }

    public ResponseEntity verTodosProdutos() {
        var saveGet = produtoRepository.findAll();

        List<DTOProdutoSemDTO> collect = DTOProdutoSemDTO.fromProdutoList(saveGet);

        return ResponseEntity.ok(collect);
    }

    public ResponseEntity verProdutoPorId(Long id) {

        var saveGet = produtoRepository.getReferenceById(id);

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (!produtoOptional.isPresent()) {
            return ResponseEntity.status(404).body("Produto não Encontrado");
        }

        return ResponseEntity.ok(new DTOProdutoSemDTO(saveGet));
    }

    public ResponseEntity deletarProdutoPorId(Long id) {

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (!produtoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        produtoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
