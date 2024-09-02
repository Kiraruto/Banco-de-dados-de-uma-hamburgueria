package br.gustavo.hemburguer.entity_tables.table_pedido.dto;

import br.gustavo.hemburguer.entity_tables.table_pedido.Perfil;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record DTOPerfil(@NotNull String name,
                        @NotNull String email
) {
    public static List<DTOPerfil> fromPerfilList(List<Perfil> perfis) {
        return perfis.stream()
                .map(perfil -> new DTOPerfil(perfil.getName(), perfil.getEmail()))
                .collect(Collectors.toList());
    }
}
