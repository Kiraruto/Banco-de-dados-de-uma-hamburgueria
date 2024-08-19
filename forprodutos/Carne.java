package br.gustavo.hemburguer.tables.forprodutos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "carne")
@Table(name = "carne")
@NoArgsConstructor
@AllArgsConstructor
public class Carne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double fat_percentage;
    private Integer weight;
    private Double price;
    private Timestamp validity;
}
