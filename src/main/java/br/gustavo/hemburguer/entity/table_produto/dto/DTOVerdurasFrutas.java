package br.gustavo.hemburguer.entity.table_produto.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DTOVerdurasFrutas(@NotNull String name,
                                @NotNull String origin,
                                @NotNull Double weight,
                                @NotNull Timestamp harvest_date,
                                @NotNull Double price,
                                @NotNull Timestamp validity,
                                Long produto_id) {
}
