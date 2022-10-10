package devinhouse.pratica.interfacefuncional;

public class Main {
    public static void main(String[] args) {
        Autenticavel aut = (nome, senha) -> nome.equals(senha);
    }
}
