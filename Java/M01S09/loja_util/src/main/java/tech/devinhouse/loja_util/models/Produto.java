package tech.devinhouse.loja_util.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "produto")
public class Produto {
    // id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ativo BOOLEAN NOT NULL,
    @Column(nullable = false)
    private Boolean ativo;

    // sku VARCHAR(50) NOT NULL UNIQUE,
    @Column(length = 50, nullable = false, unique = true)
    private String sku;

    // nome VARCHAR(100) NOT NULL,
    @Column(length = 100, nullable = false)
    private String nome;

    // descricao VARCHAR(100),
    @Column(length = 100)
    private String descricao;

    // valor_unitario DECIMAL(10,2) UNSIGNED NOT NULL
    @Column(name = "valor_unitario", columnDefinition = "DECIMAL(10,2) UNSIGNED NOT NULL", nullable = false)
    private Double valorUnitario;
}
