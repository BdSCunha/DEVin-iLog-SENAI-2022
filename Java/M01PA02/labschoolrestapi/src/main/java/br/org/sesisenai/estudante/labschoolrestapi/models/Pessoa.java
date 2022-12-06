package br.org.sesisenai.estudante.labschoolrestapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  // WARN 19540   org.hibernate.cfg.AnnotationBinder    HHH000503: A class should not be annotated with both @Inheritance and @MappedSuperclass. @Inheritance will be ignored for: tech.devinhouse.ilog.labschoolrestapi.models.Pessoa
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pessoa")
public class Pessoa {
    public enum EstadoAluno {
        ATIVO,
        INATIVO,
        IRREGULAR,
        ATENDIMENTO_PEDAGOGICO
    }

    public enum EstadoProfessor {
        ATIVO,
        INATIVO
    }

    public enum ExperienciaProfessor {
        FRONT_END,
        BACK_END,
        FULL_STACK
    }

    public enum FormacaoProfessor {
        GRADUACAO_INCOMPLETA,
        GRADUACAO_COMPLETA,
        MESTRADO,
        DOUTORADO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "telefone", nullable = false, length = 13)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Column(name = "cpf", unique = true, nullable = false)
    private Long cpf;

    // Aluno
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_aluno", length = 50)    // @Column(name = "estado_aluno", length = 50)
    private EstadoAluno estadoAluno;

    private Double nota;

    // Aluno e Pedagogo
    @Column(name = "atendimentos_pedagogicos")
    private Integer atendimentosPedagogicos;

    // Professor
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_professor", length = 50)
    private EstadoProfessor estadoProfessor;

    @Enumerated(EnumType.STRING)
    @Column(name = "experiencia_professor", length = 50)
    private ExperienciaProfessor experienciaProfessor;

    @Enumerated(EnumType.STRING)
    @Column(name = "formacao_professor", length = 50)
    private FormacaoProfessor formacaoProfessor;
}
