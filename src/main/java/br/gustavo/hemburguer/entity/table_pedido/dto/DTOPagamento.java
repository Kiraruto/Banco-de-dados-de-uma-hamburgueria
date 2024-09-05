package br.gustavo.hemburguer.entity.table_pedido.dto;

import jakarta.validation.constraints.NotNull;

public record DTOPagamento(@NotNull String payment_method,
                           @NotNull Long pedido_id) {
}
