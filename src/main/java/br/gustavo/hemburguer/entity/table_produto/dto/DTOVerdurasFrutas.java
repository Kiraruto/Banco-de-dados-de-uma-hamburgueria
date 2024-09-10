package br.gustavo.hemburguer.entity.table_produto.dto;

import br.gustavo.hemburguer.entity.table_produto.VerdurasFrutas;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public record DTOVerdurasFrutas(@NotNull String name,
                                @NotNull String origin,
                                @NotNull Double weight,
                                @NotNull Timestamp harvest_date,
                                @NotNull Double price,
                                @NotNull Timestamp validity,
                                Long produto_id) {
    public static @NotNull List<DTOVerdurasFrutas> fromList(List<VerdurasFrutas> verdurasFrutas) {
        return verdurasFrutas.stream()
                .map(v -> new DTOVerdurasFrutas(
                        v.getName(),
                        v.getOrigin(),
                        v.getWeight(),
                        v.getHarvest_date(),
                        v.getPrice(),
                        v.getValidity(),
                        v.getProdutoId()))
                .collect(Collectors.toList());
    }
}
