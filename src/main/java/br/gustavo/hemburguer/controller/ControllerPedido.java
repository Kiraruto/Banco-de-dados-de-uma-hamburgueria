package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.repository.PedidoRepository;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ControllerPedido {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity postPedido(@RequestBody @Valid DTOPedido dtoPedido) {

        return pedidoService.save(dtoPedido);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putPedido(@PathVariable Long id) {

        return pedidoService.setStatusTrue(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePedido(@PathVariable Long id) {

        return pedidoService.deleteById(id);
    }
}
