package devinhouse.pratica.interfacefuncional;

@FunctionalInterface
public interface Autenticavel {
    public default boolean autenticar(String nome, String senha) {
        return nome.equals(senha);
    }
}
