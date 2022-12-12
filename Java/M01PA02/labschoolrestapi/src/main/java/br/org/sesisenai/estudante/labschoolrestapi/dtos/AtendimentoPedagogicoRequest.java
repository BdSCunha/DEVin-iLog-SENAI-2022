package br.org.sesisenai.estudante.labschoolrestapi.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AtendimentoPedagogicoRequest {
    @NotNull(message = "{campo.obrigatorio}")
    @Positive(message = "{campo.invalido}")
    private Long codigoAluno;

    @NotNull(message = "{campo.obrigatorio}")
    @Positive(message = "{campo.invalido}")
    private Long codigoPedagogo;
}
