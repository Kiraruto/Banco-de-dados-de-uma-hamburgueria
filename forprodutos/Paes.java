package br.gustavo.hemburguer.tables.forprodutos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "paes")
@Table(name = "paes")
@NoArgsConstructor
@AllArgsConstructor
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
}
