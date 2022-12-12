package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
public class AlunoDTO {
    @NotEmpty(message = "{campo.obrigatorio}")
    @NotNull(message = "{campo.obrigatorio}")
    @NotBlank(message = "{campo.invalido}")
    @Size(max = 200)
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @NotNull(message = "{campo.obrigatorio}")
    @NotBlank(message = "{campo.invalido}")
    @Size(min = 12, max = 13)
    private String telefone;

    @NotNull(message = "{campo.obrigatorio}")
    @Past(message = "{campo.invalido}")
    private LocalDate dataNascimento;

    @NotNull(message = "{campo.obrigatorio}")
    private Long cpf;

    @NotNull(message = "{campo.obrigatorio}")
    private Situacao situacao;

    @NotNull(message = "{campo.obrigatorio}")
    @Range(min = 0, max = 10, message = "{campo.invalido}")
    private Double nota;

    private Integer atendimentos = 0;
}
