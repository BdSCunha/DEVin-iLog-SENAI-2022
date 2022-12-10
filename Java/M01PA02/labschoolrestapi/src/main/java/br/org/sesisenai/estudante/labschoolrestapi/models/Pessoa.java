package br.org.sesisenai.estudante.labschoolrestapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "codigo", nullable = false, updatable = false)
    private Long codigo;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 13)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Column(name = "cpf", unique = true, nullable = false, columnDefinition = "BIGINT UNSIGNED NOT NULL UNIQUE")
    private Long cpf;
}
