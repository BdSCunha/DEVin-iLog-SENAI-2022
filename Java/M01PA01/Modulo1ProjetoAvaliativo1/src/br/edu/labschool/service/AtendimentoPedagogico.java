package br.edu.labschool.service;

import br.edu.labschool.model.Aluno;
import br.edu.labschool.model.Pedagogo;
import br.edu.labschool.model.Aluno.StatusMatriculaAluno;

public class AtendimentoPedagogico {
    public static void atendimentoPedagogico(Aluno aluno, Pedagogo pedagogo) {
        pedagogo.setAtendimentosRealizados(pedagogo.getAtendimentosRealizados() + 1);

        aluno.setAtendimentosSolicitados(aluno.getAtendimentosSolicitados() + 1);
        aluno.setStatusMatricula(StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO);
    }
}
