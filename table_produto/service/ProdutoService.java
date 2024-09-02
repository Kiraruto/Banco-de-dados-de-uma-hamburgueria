package br.gustavo.hemburguer.entity_tables.table_produto.service;

import br.gustavo.hemburguer.entity_tables.table_produto.Produto;
import br.gustavo.hemburguer.entity_tables.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity_tables.table_produto.dto.DTOProdutoSemDTO;
import br.gustavo.hemburguer.entity_tables.table_produto.repository.CarneRepository;
import br.gustavo.hemburguer.entity_tables.table_produto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CarneRepository carneRepository;

    @Transactional
    public void save(DTOProduto dtoProduto) {
        produtoRepository.save(new Produto(dtoProduto));
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
}
