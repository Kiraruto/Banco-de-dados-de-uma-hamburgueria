package br.gustavo.hemburguer.entity.table_produto.dto;

import br.gustavo.hemburguer.entity.table_produto.Carne;
import br.gustavo.hemburguer.entity.table_produto.Paes;
import br.gustavo.hemburguer.entity.table_produto.Produto;
import br.gustavo.hemburguer.entity.table_produto.VerdurasFrutas;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record DTOProdutoSemDTO(@NotNull String name,
                               @NotNull List<Carne> carne_id,
                               @NotNull Paes paes_id,
                               @NotNull List<VerdurasFrutas> verdurasFrutas_id) {

    public DTOProdutoSemDTO(Produto saveGet) {
        this(saveGet.getName(), saveGet.getCarnes_id(), saveGet.getPaes_id(), saveGet.getVerdurasFrutas_id());
    }

    public static List<DTOProdutoSemDTO> fromProdutoList(List<Produto> saveGet) {
        return saveGet.stream()
                .map(p -> new DTOProdutoSemDTO(p.getName(), p.getCarnes_id(), p.getPaes_id(), p.getVerdurasFrutas_id()))
                .collect(Collectors.toList());
    }
}
