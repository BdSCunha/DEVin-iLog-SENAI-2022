package br.org.sesisenai.estudante.labschoolrestapi.services;

import br.org.sesisenai.estudante.labschoolrestapi.dtos.AtendimentoPedagogicoResponse;
import br.org.sesisenai.estudante.labschoolrestapi.enums.Situacao;
import br.org.sesisenai.estudante.labschoolrestapi.models.Aluno;
import br.org.sesisenai.estudante.labschoolrestapi.models.Pedagogo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtendimentoPedagogicoService {
    private AlunoService alunoService;
    private PedagogoService pedagogoService;

    @Transactional
    public AtendimentoPedagogicoResponse atendimentoPedagogico(Aluno aluno, Pedagogo pedagogo) {
        Aluno alunoCopia = new Aluno();
        BeanUtils.copyProperties(aluno, alunoCopia);

        Pedagogo pedagogoCopia = new Pedagogo();
        BeanUtils.copyProperties(pedagogo, pedagogoCopia);

        alunoCopia.setAtendimentos(alunoCopia.getAtendimentos() + 1);
        alunoCopia.setSituacao(Situacao.ATENDIMENTO_PEDAGOGICO);
        alunoService.save(alunoCopia);

        pedagogoCopia.setAtendimentos(pedagogoCopia.getAtendimentos() + 1);
        pedagogoService.save(pedagogoCopia);

        return new AtendimentoPedagogicoResponse(alunoCopia, pedagogoCopia);
    }
}
