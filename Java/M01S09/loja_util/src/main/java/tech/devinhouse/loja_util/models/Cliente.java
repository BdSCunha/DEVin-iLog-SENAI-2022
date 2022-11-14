package tech.devinhouse.loja_util.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    // id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ativo BOOLEAN NOT NULL,
    @Column(nullable = false)
    private Boolean ativo;

    // nome VARCHAR(100) NOT NULL,
    @Column(length = 100, nullable = false)
    private String nome;

    // cpf_cnpj VARCHAR(14) NOT NULL UNIQUE
    @Column(name = "cpf_cnpj", length = 14, nullable = false, unique = true)
    private String cpfCnpj;
}
