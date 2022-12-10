package br.org.sesisenai.estudante.labschoolrestapi.models;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Estado;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Experiencia;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Formacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa {
    @Column(name = "formacao", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Formacao formacao;

    @Column(name = "experiencia", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Experiencia experiencia;

    @Column(name = "estado", nullable = false, length = 7)
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
