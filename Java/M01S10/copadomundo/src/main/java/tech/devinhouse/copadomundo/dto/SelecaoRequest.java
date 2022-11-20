package tech.devinhouse.copadomundo.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SelecaoRequest {
    @NotEmpty(message = "{campo.obrigatorio}")
    @NotBlank
    @Size(min = 3, max = 3, message = "{campo.invalido}")
    private String sigla;

    @NotEmpty(message = "{campo.obrigatorio}")
    @NotBlank
    @Size(min = 3, max = 50, message = "{campo.invalido}")
    private String nome;

    @NotEmpty(message = "{campo.obrigatorio}")
    @NotBlank
    @Size(min = 1, max = 1, message = "{campo.invalido}")
    private String grupo;
}
