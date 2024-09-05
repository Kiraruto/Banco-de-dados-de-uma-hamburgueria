package br.gustavo.hemburguer.entity.table_pedido.dto;

import jakarta.validation.constraints.NotNull;

public record DTOPedido(@NotNull Long usuario_id) {
}
