package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtendimentoPedagogicoResponse {
    @NotNull(message = "{campo.obrigatorio}")
    private Aluno aluno;

    @NotNull(message = "{campo.obrigatorio}")
    private Pedagogo pedagogo;
}
