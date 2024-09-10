package br.gustavo.hemburguer.entity.table_pedido.service;

import br.gustavo.hemburguer.entity.repository.PedidoRepository;
import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.Pedido;
import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity save(DTOPedido dtoPedido) {

        if (dtoPedido.usuario_id() == null) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dtoPedido.usuario_id());

        if (usuarioOptional.isPresent()) {
            Pedido pedido = new Pedido(dtoPedido);

            pedidoRepository.save(pedido);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("O id não existe");
    }

    public ResponseEntity setStatusTrue(Long id) {

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Pedido> pedidoOptionalStatus = pedidoRepository.findStatusById(id);

        var savePedido = pedidoOptionalStatus.get();
        savePedido.statusTrue();

        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteById(Long id) {

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (!pedidoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        pedidoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
