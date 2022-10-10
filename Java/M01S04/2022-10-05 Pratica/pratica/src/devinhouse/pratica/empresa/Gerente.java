package devinhouse.pratica.empresa;

public class Gerente extends Funcionario implements Autenticavel {

    @Override
    public String obterCategoria() {
        return "Sou Gerente.";
    }
    
    @Override
    public boolean autenticar(String nome, String senha) {
        return Autenticavel.super.autenticar(nome, senha);
    }
}
