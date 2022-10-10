package devinhouse.pratica.empresa;

public class Diretor extends Funcionario implements Autenticavel {

    @Override
    public String obterCategoria() {
        return "Sou Diretor(a).";
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return Autenticavel.super.autenticar(nome, senha);
    }
}
