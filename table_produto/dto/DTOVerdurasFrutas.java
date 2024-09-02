package br.gustavo.hemburguer.entity_tables.table_produto.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DTOVerdurasFrutas(@NotNull String name,
                                @NotNull String origin,
                                @NotNull Integer weight,
                                @NotNull Timestamp harvest_date,
                                @NotNull Integer price,
                                @NotNull Timestamp validity,
                                Long produto_id) {
}
