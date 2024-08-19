package br.gustavo.hemburguer.tables.forprodutos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "produto")
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Carne> carne_id;
    @OneToOne
    private Paes paes_id;
    @OneToMany
    private List<VerdurasFrutas> verdurasFrutas_id;
}
