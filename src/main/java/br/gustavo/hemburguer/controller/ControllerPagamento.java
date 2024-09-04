package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity_tables.repository.PagamentoRepository;
import br.gustavo.hemburguer.entity_tables.table_pedido.Pagamento;
import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOPagamento;
import br.gustavo.hemburguer.entity_tables.table_pedido.service.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class ControllerPagamento {

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity postPagamento(@RequestBody @Valid DTOPagamento dtoPagamento) {

        return pagamentoService.save(dtoPagamento);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putPagamento(@PathVariable Long id) {

        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);

        if (!pagamentoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Pagamento> pagamentoOptionalStatus = pagamentoRepository.findStatusById(id);

        var savePagamento = pagamentoOptionalStatus.get();
        savePagamento.statusTrue();

        return ResponseEntity.ok().build();

    }

}
