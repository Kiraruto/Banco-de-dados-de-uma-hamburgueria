package br.gustavo.hemburguer.entity.table_pedido.dto;

import br.gustavo.hemburguer.entity.table_pedido.Endereco;
import jakarta.validation.constraints.NotNull;

public record DTOEndereco(@NotNull Long user,
                          @NotNull String street,
                          @NotNull String number,
                          @NotNull String city,
                          @NotNull Integer zip_code,
                          @NotNull String state) {
    public DTOEndereco(Endereco endereco) {
        this(endereco.getUser(), endereco.getStreet(), endereco.getNumber(), endereco.getCity(), endereco.getZip_code(), endereco.getState());
    }
}
