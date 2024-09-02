package br.gustavo.hemburguer.entity_tables.table_produto.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DTOCarne(@NotNull String name,
                       @NotNull String origin,
                       @NotNull Double fat_percentage,
                       @NotNull Integer weight,
                       @NotNull Double price,
                       @NotNull Timestamp harvest_date,
                       @NotNull Timestamp validity,
                       Long produto_id) {
}
