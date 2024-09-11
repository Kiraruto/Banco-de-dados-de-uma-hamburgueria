package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOCarne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "carne")
@Table(name = "carne")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Carne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String origin;
    private Double fat_percentage;
    private Integer weight;
    private Double price;
    private Timestamp harvest_date;
    private Timestamp validity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    @Setter
    private Produto produto_id;

    public Carne(DTOCarne dtoCarne) {
        this.name = dtoCarne.name();
        this.origin = dtoCarne.origin();
        this.fat_percentage = dtoCarne.fat_percentage();
        this.weight = dtoCarne.weight();
        this.price = dtoCarne.price();
        this.harvest_date = dtoCarne.harvest_date();
        this.validity = dtoCarne.validity();
    }


    public Long getProdutoId() {
        return produto_id != null ? produto_id.getId() : null;
    }
}
