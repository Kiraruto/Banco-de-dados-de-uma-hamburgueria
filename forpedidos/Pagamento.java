package br.gustavo.hemburguer.tables.forpedidos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "pagamento")
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Pedido pedido_id;
    private String payment_method;
    private Boolean status;
}
