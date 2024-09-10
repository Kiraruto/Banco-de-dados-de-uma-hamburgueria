package br.gustavo.hemburguer.entity.table_produto.dto;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public record DTOCarne(@NotNull String name,
                       @NotNull String origin,
                       @NotNull Double fat_percentage,
                       @NotNull Integer weight,
                       @NotNull Double price,
                       @NotNull Timestamp harvest_date,
                       @NotNull Timestamp validity,
                       Long produto_id) {
    public static List<DTOCarne> fromList(List<Carne> carnes) {
        return carnes.stream()
                .map(c -> new DTOCarne(c.getName(), c.getOrigin(), c.getFat_percentage(), c.getWeight(), c.getPrice(), c.getHarvest_date(), c.getValidity(), c.getProdutoId()))
                .collect(Collectors.toList());
    }
}
