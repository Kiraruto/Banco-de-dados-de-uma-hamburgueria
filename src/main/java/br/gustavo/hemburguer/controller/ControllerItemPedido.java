package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOItemPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.ItemPedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("itemPedido")
public class ControllerItemPedido {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity postItemPedido(@RequestBody @Valid DTOItemPedido dtoItemPedido) {

        return itemPedidoService.save(dtoItemPedido);
    }

    @GetMapping
    public ResponseEntity getItensPedido() {

        return itemPedidoService.get();
    }
}
