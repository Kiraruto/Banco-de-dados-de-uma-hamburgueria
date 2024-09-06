package br.gustavo.hemburguer.security.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String email,
                                @NotNull String password) {
}
