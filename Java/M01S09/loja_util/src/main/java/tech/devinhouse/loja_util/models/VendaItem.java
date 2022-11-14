package tech.devinhouse.loja_util.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "venda_item")
public class VendaItem {
    // id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // quantidade DECIMAL(10,1) UNSIGNED NOT NULL,
    @Column(columnDefinition = "DECIMAL(10,1) UNSIGNED NOT NULL", nullable = false)
    private Double quantidade;

    // valor_unitario DECIMAL(10,2) UNSIGNED NOT NULL,
    @Column(name = "valor_unitario", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL", nullable = false)
    private Double valorUnitario;

    // valor_total DECIMAL(10,2) UNSIGNED NOT NULL,
    @Column(name = "valor_total", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL", nullable = false)
    private Double valorTotal;

    // venda_id INT NOT NULL,
    @Column(name = "venda_id", nullable = false)
    private Integer vendaId;

    // produto_id INT NOT NULL,
    @Column(name = "produto_id", nullable = false)
    private Integer produtoId;

    // CONSTRAINT fk_venda_item_venda FOREIGN KEY (venda_id) REFERENCES venda(id),
    @ManyToOne
    @JoinColumn(name = "venda_id", insertable = false, updatable = false)
    private Venda venda;

    // CONSTRAINT fk_venda_item_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
    @ManyToOne
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;
}
