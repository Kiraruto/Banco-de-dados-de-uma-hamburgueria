package br.gustavo.hemburguer.entity.table_pedido;

import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPagamento;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "pagamento")
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String payment_method;
    private Boolean status;
    private Long pedido_id;

    public Pagamento(@Valid DTOPagamento dtoPagamento) {
        this.payment_method = dtoPagamento.payment_method();
        this.status = false;
        this.pedido_id = dtoPagamento.pedido_id();
    }

    public void statusTrue() {
        this.status = true;
    }
}
