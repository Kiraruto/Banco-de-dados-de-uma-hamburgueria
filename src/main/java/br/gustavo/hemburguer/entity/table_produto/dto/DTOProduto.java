package br.gustavo.hemburguer.entity.table_produto.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DTOProduto(@NotNull String name,
                         @NotNull List<DTOCarne> carne_id,
                         @NotNull DTOPaes paes_id,
                         @NotNull List<DTOVerdurasFrutas> verdurasFrutas_id) {

}
