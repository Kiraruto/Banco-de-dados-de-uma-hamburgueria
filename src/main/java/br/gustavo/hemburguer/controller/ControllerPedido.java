package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.repository.PedidoRepository;
import br.gustavo.hemburguer.entity.table_pedido.Pedido;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Pedido> pedidoOptionalStatus = pedidoRepository.findStatusById(id);

        var savePedido = pedidoOptionalStatus.get();
        savePedido.statusTrue();

        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePedido(@PathVariable Long id) {

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        pedidoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
