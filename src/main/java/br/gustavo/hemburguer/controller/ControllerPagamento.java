package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.repository.PagamentoRepository;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPagamento;
import br.gustavo.hemburguer.entity.table_pedido.service.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return pagamentoService.salvarTruePagamento(id);

    }

}