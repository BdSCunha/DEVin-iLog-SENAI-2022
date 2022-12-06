package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pessoa;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class AlunoDTO {
    @NotBlank @NotNull @NotEmpty
    @Size(max = 200)
    private String nome;

    @NotBlank @NotNull @NotEmpty
    @Size(max = 13)
    private String telefone;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotNull
    private Long cpf;

    private Pessoa.EstadoAluno estadoAluno;

    @Range(min = 0, max = 10)
    private Double nota;

    private Integer atendimentosPedagogicos;
}
