package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOPaes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "paes")
@Table(name = "paes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Paes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type_of_bread;
    private Integer weight;
    private Timestamp manufacturing_date;
    private Double price;
    private Timestamp validity;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    @Setter
    private Produto produto_id;

    public Paes(@NotNull DTOPaes dtoPaes) {
        this.name = dtoPaes.name();
        this.type_of_bread = dtoPaes.type_of_bread();
        this.weight = dtoPaes.weight();
        this.manufacturing_date = dtoPaes.manufacturing_date();
        this.price = dtoPaes.price();
        this.validity = dtoPaes.validity();
    }

    public Paes(long l) {
        this.id = l;
    }


    public Long getProdutoId() {
        return produto_id != null ? produto_id.getId() : null;
    }
}
