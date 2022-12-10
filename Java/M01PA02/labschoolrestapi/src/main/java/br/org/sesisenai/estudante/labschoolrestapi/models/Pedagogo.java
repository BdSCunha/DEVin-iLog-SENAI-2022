package br.org.sesisenai.estudante.labschoolrestapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedagogos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedagogo extends Pessoa {
    @Column(name = "atendimentos", nullable = false, columnDefinition = "INT UNSIGNED")
    private Integer atendimentos;
}
