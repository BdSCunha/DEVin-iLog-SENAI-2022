package devinhouse.pratica.empresa;

public interface Autenticavel {
    public default boolean autenticar(String nome, String senha) {
        // if(nome == Funcionario.getNome() && senha == Funcionario.getSenha()) {
        //     return true;
        // } else {
        //     return false;
        // }
        return false;
    }
}
