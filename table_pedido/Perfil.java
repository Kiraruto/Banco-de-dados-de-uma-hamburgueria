package br.gustavo.hemburguer.entity_tables.table_pedido;

import br.gustavo.hemburguer.entity_tables.table_pedido.dto.DTOUsuairo;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "perfil")
@Table(name = "perfil")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public Perfil(@Valid DTOUsuairo dtoUsuairo) {
        this.name = dtoUsuairo.name();
        this.email = dtoUsuairo.email();
    }
}
