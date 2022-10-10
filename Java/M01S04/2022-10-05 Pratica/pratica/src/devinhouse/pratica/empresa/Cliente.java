package devinhouse.pratica.empresa;

public class Cliente implements Autenticavel {
    @Override
    public boolean autenticar(String nome, String senha) {
        return Autenticavel.super.autenticar(nome, senha);
    }
}
