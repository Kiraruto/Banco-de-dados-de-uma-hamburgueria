package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "pedido")
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp data;
    private Boolean status;
    private Long usuario_id;

    public Pedido(DTOPedido dtoPedido) {
        this.data = Timestamp.valueOf(LocalDateTime.now());
        this.status = false;
        this.usuario_id = dtoPedido.usuario_id();
    }

    public void statusTrue() {
        this.status = true;
    }
}
