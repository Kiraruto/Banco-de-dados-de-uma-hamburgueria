package br.gustavo.hemburguer.entity.table_produto;

import br.gustavo.hemburguer.entity.table_produto.dto.DTOCarne;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOProduto;
import br.gustavo.hemburguer.entity.table_produto.dto.DTOVerdurasFrutas;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "produto")
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "produto_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carne> carnes_id;

    @OneToOne(mappedBy = "produto_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private Paes paes_id;

    @OneToMany(mappedBy = "produto_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VerdurasFrutas> verdurasFrutas_id;

    public Produto(DTOProduto dtoProduto) {
        this.name = dtoProduto.name();

        if (dtoProduto.carne_id() != null) {
            this.carnes_id = new ArrayList<>();
            for (DTOCarne dtoCarne : dtoProduto.carne_id()) {
                Carne carne = new Carne(dtoCarne);
                carne.setProduto_id(this);
                this.carnes_id.add(carne);
            }
        }

        if (dtoProduto.paes_id() != null) {
            this.paes_id = new Paes(dtoProduto.paes_id());
            this.paes_id.setProduto_id(this);
        }

        if (dtoProduto.verdurasFrutas_id() != null) {
            this.verdurasFrutas_id = new ArrayList<>();
            for (DTOVerdurasFrutas dtoVerduraFruta : dtoProduto.verdurasFrutas_id()) {
                VerdurasFrutas verduraFruta = new VerdurasFrutas(dtoVerduraFruta);
                verduraFruta.setProduto_id(this);
                this.verdurasFrutas_id.add(verduraFruta);
            }
        }
    }

    public void atualizarInformacoes(@Valid DTOProduto dtoProduto) {

        if (dtoProduto.carne_id() != null) {
            carnes_id.clear();
            for (DTOCarne dtoCarne : dtoProduto.carne_id()) {
                Carne carne = new Carne(dtoCarne);
                carne.setProduto_id(this);
                this.carnes_id.add(carne);
            }
        }

        if (dtoProduto.paes_id() != null) {
            this.paes_id = new Paes(dtoProduto.paes_id());
            this.paes_id.setProduto_id(this);
        }

        if (dtoProduto.verdurasFrutas_id() != null) {
            verdurasFrutas_id.clear();
            for (DTOVerdurasFrutas dtoVerduraFruta : dtoProduto.verdurasFrutas_id()) {
                VerdurasFrutas verduraFruta = new VerdurasFrutas(dtoVerduraFruta);
                verduraFruta.setProduto_id(this);
                this.verdurasFrutas_id.add(verduraFruta);
            }
        }
    }
}
