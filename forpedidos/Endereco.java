package br.gustavo.hemburguer.tables.forpedidos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Usuario usuario_id;
    private String street;
    private Integer number;
    private String city;
    private Integer zip_code;
    private Boolean state;
}
