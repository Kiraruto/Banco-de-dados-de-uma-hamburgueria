package br.gustavo.hemburguer.entity_tables.table_pedido;

import br.gustavo.hemburguer.entity_tables.table_produto.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "item_pedido")
@Table(name = "item_pedido")
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Produto produto_id;
    @OneToOne
    private Pedido pedido_id;
}
