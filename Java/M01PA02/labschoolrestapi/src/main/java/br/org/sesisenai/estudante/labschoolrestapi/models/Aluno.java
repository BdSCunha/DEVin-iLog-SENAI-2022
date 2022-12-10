package br.org.sesisenai.estudante.labschoolrestapi.models;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno extends Pessoa {
    @Column(name = "situacao", nullable = false, length = 22)
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @Column(name = "nota", nullable = false)
    private Double nota;

    @Column(name = "atendimentos", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer atendimentos;

    public Aluno(Long codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, Situacao situacao, Double nota, Integer atendimentos) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.situacao = situacao;
        this.nota = nota;
        this.atendimentos = atendimentos;
    }
}
