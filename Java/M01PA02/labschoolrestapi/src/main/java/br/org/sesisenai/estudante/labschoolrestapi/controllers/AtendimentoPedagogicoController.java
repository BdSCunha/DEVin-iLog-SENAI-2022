package br.org.sesisenai.estudante.labschoolrestapi.controllers;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AtendimentoPedagogicoRequest;
import br.org.sesisenai.estudante.labschoolrestapi.dtos.AtendimentoPedagogicoResponse;
import br.org.sesisenai.estudante.labschoolrestapi.dtos.SituacaoAlunoDTO;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.services.AlunoService;
import br.org.sesisenai.estudante.labschoolrestapi.services.AtendimentoPedagogicoService;
import br.org.sesisenai.estudante.labschoolrestapi.services.PedagogoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/atendimentos")
@AllArgsConstructor
public class AtendimentoPedagogicoController {
    private AtendimentoPedagogicoService atendimentoPedagogicoService;
    private AlunoService alunoService;
    private PedagogoService pedagogoService;

    // RF09 - Realização de Atendimento Pedagógico
    @PutMapping
    public ResponseEntity<Object> atendimentoPedagogico(@RequestBody @Valid AtendimentoPedagogicoRequest atendimentoPedagogicoRequest) {
        Long codigoAluno = atendimentoPedagogicoRequest.getCodigoAluno();
        if (alunoService.findAlunoByCodigo(codigoAluno).isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado / inexistente.");
        var aluno = alunoService.findAlunoByCodigo(codigoAluno).get();

        Long codigoPedagogo = atendimentoPedagogicoRequest.getCodigoPedagogo();
        if (pedagogoService.findPedagogoByCodigo(codigoPedagogo).isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedagogo não encontrado / inexistente.");
        var pedagogo = pedagogoService.findPedagogoByCodigo(codigoPedagogo).get();

        atendimentoPedagogicoService.atendimentoPedagogico(aluno, pedagogo);
//        aluno.setAtendimentos(aluno.getAtendimentos() + 1);
//        aluno.setSituacao(Situacao.ATENDIMENTO_PEDAGOGICO);
//        alunoService.save(aluno);
//
//        pedagogo.setAtendimentos(pedagogo.getAtendimentos() + 1);
//        pedagogoService.save(pedagogo);

        return ResponseEntity.status(HttpStatus.OK).body(new AtendimentoPedagogicoResponse(aluno, pedagogo));
    }
}
