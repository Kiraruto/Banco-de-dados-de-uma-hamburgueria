package br.gustavo.hemburguer.tables.forpedidos;

import br.gustavo.hemburguer.tables.forprodutos.Produto;
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
