package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.models.Pessoa;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProfessorDTO {
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

    private Pessoa.EstadoProfessor estadoProfessor;

    private Pessoa.ExperienciaProfessor experienciaProfessor;

    private Pessoa.FormacaoProfessor formacaoProfessor;
}
