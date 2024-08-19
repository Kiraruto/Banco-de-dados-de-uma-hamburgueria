package br.gustavo.hemburguer.tables.forprodutos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "verduras_frutas")
@Table(name = "verduras_frutas")
@NoArgsConstructor
@AllArgsConstructor
public class VerdurasFrutas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String origin;
    private Integer weight;
    private Timestamp harvest_date;
    private Integer price;
    private Timestamp validity;
}
