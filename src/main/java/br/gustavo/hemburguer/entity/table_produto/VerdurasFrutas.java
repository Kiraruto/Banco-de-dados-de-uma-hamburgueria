package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOVerdurasFrutas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "verduras_frutas")
@Table(name = "verduras_frutas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class VerdurasFrutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String origin;
    private Double weight;
    private Timestamp harvest_date;
    private Double price;
    private Timestamp validity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    @Setter
    private Produto produto_id;

    public VerdurasFrutas(@NotNull DTOVerdurasFrutas dtoVerdurasFrutas) {
        this.name = dtoVerdurasFrutas.name();
        this.origin = dtoVerdurasFrutas.origin();
        this.weight = dtoVerdurasFrutas.weight();
        this.harvest_date = dtoVerdurasFrutas.harvest_date();
        this.price = dtoVerdurasFrutas.price();
        this.validity = dtoVerdurasFrutas.validity();
    }

    public Long getProdutoId() {
        return produto_id != null ? produto_id.getId() : null;
    }
}
