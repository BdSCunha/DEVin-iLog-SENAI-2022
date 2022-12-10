package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class AlunoDto {
    @NotEmpty @NotBlank @NotNull
    @Size(max = 200)
    private String nome;

    @NotEmpty @NotBlank @NotNull
    @Size(min = 12, max = 13)
    private String telefone;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotNull
    private Long cpf;

    @NotNull
    private Situacao situacao;

    @NotNull
    @Range(min = 0, max = 10)
    private Double nota;

    @NotNull
    private Integer atendimentos = 0;
}
