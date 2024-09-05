package br.gustavo.hemburguer.entity.table_pedido.service;

import br.gustavo.hemburguer.entity.repository.ItemPedidoRepository;
import br.gustavo.hemburguer.entity.repository.PedidoRepository;
import br.gustavo.hemburguer.entity.repository.UsuarioRepository;
import br.gustavo.hemburguer.entity.table_pedido.ItemPedido;
import br.gustavo.hemburguer.entity.table_pedido.Pedido;
import br.gustavo.hemburguer.entity.table_pedido.Usuario;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOItemPedido;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ResponseEntity save(@Valid DTOItemPedido dtoItemPedido) {

        Optional<Pedido> peidoOptional = pedidoRepository.findById(dtoItemPedido.pedido_id());
        Optional<Produto> produtoOptional = produtoRepository.findById(dtoItemPedido.produto_id());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(dtoItemPedido.usuario_id());

        if (!peidoOptional.isPresent() || !produtoOptional.isPresent() || !usuarioOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        if (peidoOptional.isPresent() || produtoOptional.isPresent() || usuarioOptional.isPresent()) {
            ItemPedido itemPedido = new ItemPedido(dtoItemPedido);

            itemPedidoRepository.save(itemPedido);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("aaa");
    }

    public ResponseEntity get() {

        List<ItemPedido> itemPedidoList = itemPedidoRepository.findAll();

        var saveItemPedido = DTOItemPedido.fromList(itemPedidoList);

        return ResponseEntity.ok(saveItemPedido);

    }
}
