package br.gustavo.hemburguer.entity.table_produto.dto;

import br.gustavo.hemburguer.entity.table_produto.Paes;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record DTOPaes(@NotNull String name,
                      @NotNull String type_of_bread,
                      @NotNull Integer weight,
                      @NotNull Timestamp manufacturing_date,
                      @NotNull Double price,
                      @NotNull Timestamp validity,
                      Long produto_id) {

    public DTOPaes(Paes paes) {
        this(paes.getName(), paes.getType_of_bread(), paes.getWeight(), paes.getManufacturing_date(), paes.getPrice(), paes.getValidity(), paes.getProdutoId());
    }
}
