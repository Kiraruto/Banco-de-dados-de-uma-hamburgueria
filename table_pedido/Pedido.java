package br.gustavo.hemburguer.entity_tables.table_pedido;

import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "pedido")
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp data;
    @OneToMany(mappedBy = "pedido_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamento;
    private Boolean status;
    @ManyToOne
    private Usuario usuario_id;

    public Pedido(DTOPedido dtoPedido) {
        this.data = Timestamp.valueOf(LocalDateTime.now());
        this.pagamento = dtoPedido.pagamento();
        this.status = false;
        this.usuario_id = dtoPedido.usuario_id();
    }

    public void statusTrue() {
        this.status = true;
    }
}
