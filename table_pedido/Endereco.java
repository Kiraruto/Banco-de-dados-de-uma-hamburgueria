package br.gustavo.hemburguer.entity_tables.table_pedido;

import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOEndereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user;
    private String street;
    private String number;
    private String city;
    private Integer zip_code;
    private String state;

    public Endereco(DTOEndereco dtoEndereco) {
        this.user = dtoEndereco.user();
        this.street = dtoEndereco.street();
        this.number = dtoEndereco.number();
        this.city = dtoEndereco.city();
        this.zip_code = dtoEndereco.zip_code();
        this.state = dtoEndereco.state();
    }

    public void atualizarInformacoes(@Valid DTOEndereco dtoEndereco) {
        if (dtoEndereco.user() != null) {
            this.user = dtoEndereco.user();
        }
        if (dtoEndereco.street() != null) {
            this.street = dtoEndereco.street();
        }
        if (dtoEndereco.number() != null) {
            this.number = dtoEndereco.number();
        }
        if (dtoEndereco.city() != null) {
            this.city = dtoEndereco.city();
        }
        if (dtoEndereco.zip_code() != null) {
            this.zip_code = dtoEndereco.zip_code();
        }
        if (dtoEndereco.state() != null) {
            this.state = dtoEndereco.state();
        }
    }
}
