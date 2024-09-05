package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOItemPedido;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "item_pedido")
@Table(name = "item_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedido_id;
    private Long produto_id;
    private Long usuario_id;

    public ItemPedido(@Valid DTOItemPedido dtoItemPedido) {
        this.pedido_id = dtoItemPedido.pedido_id();
        this.produto_id = dtoItemPedido.produto_id();
        this.usuario_id = dtoItemPedido.usuario_id();
    }
}
