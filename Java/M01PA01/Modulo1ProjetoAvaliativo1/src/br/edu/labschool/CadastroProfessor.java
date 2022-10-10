package br.edu.labschool;

public class CadastroProfessor extends Pessoa {
    enum Formacao {
        GRADUACAO_COMPLETA,
        GRADUACAO_INCOMPLETA,
        MESTRADO,
        DOUTORADO
    }

    enum Experiencia {
        FRONT_END,
        BRACK_END,
        FULL_STACK
    }

    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
