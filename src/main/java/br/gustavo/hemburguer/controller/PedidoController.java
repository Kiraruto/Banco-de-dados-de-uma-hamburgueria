package br.gustavo.hemburguer.controller;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import br.gustavo.hemburguer.entity.table_pedido.service.PedidoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity postPedido(DTOPedido dtoPedido) {

        return pedidoService.save(dtoPedido);
    }
}
