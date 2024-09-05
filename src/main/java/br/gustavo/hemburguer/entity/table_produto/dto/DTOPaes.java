package br.gustavo.hemburguer.entity.table_produto.dto;

import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DTOPaes(@NotNull String name,
                      @NotNull String type_of_bread,
                      @NotNull Integer weight,
                      @NotNull Timestamp manufacturing_date,
                      @NotNull Double price,
                      @NotNull Timestamp validity,
                      Long produto_id) {

}
