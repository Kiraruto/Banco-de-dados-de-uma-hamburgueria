package br.gustavo.hemburguer.entity_tables.table_pedido.service;

import br.gustavo.hemburguer.entity_tables.repository.PedidoRepository;
import br.gustavo.hemburguer.entity_tables.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity_tables.table_pedido.Pedido;
import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOPedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity save(DTOPedido dtoPedido) {

        if (dtoPedido.usuario_id() != null) {
            return ResponseEntity.badRequest().body("Não existe usuario com este id");
        }

        pedidoRepository.save(new Pedido(dtoPedido));

        return  ResponseEntity.ok().build();
    }
}
