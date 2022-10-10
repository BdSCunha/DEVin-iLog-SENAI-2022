package br.edu.labschool;

public class CadastroAluno extends Pessoa {
    enum StatusMatricula {
        ATIVO,
        IRREGULAR,
        ATENDIMENTO_PEDAGOGICO,
        INATIVO
    }
    
    String situacaoMatricula;
    Integer nota;
    Integer atendimentos = 0;

    public String getSituacaoMatricula() {
        return situacaoMatricula;
    }
    public void setSituacaoMatricula(String situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }
    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }
    public Integer getAtendimentos() {
        return atendimentos;
    }
    public void setAtendimentos(Integer atendimentos) {
        this.atendimentos = atendimentos;
    }
}
