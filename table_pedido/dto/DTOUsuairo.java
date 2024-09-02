package br.gustavo.hemburguer.entity_tables.table_pedido.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record DTOUsuairo(@NotNull String name,
                         @NotNull @CPF String cpf,
                         @NotNull @Email String email,
                         @NotNull String password) {
}
