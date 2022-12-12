package br.org.sesisenai.estudante.labschoolrestapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pedagogos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa {
    @Column(name = "atendimentos", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer atendimentos;

    public Pedagogo(Long codigo, String nome, String telefone, LocalDate dataNascimento, Long cpf, Integer atendimentos) {
        super(codigo, nome, telefone, dataNascimento, cpf);
        this.atendimentos = atendimentos;
    }
}
