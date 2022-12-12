package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SituacaoAlunoDTO {
    @NotNull(message = "{campo.obrigatorio}")
    private Situacao situacao;
}
