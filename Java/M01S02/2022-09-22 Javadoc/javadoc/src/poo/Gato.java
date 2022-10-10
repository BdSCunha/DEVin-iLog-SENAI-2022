package poo;

public class Gato {
    public String raca = "Vira-Lata";
    public int idade = 0;
    public String cor = "Não definida";
    public String nome = "Não definido";

    /**
     * Construtor da classe Gato
     * @param raca raça do gato
     * @param idade idade do gato
     * @param cor cor do gato
     * @param nome nome do gato
     */
    public Gato(String raca, int idade, String cor, String nome) {
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.nome = nome;
    }

    /**
     * Método que retorna a onomatopeia do miado de um gato
     * @return miado
     */
    public String miar() {
        return("Miau!");
    }

    /**
     * Função que retorna a ação a ser tomada pelo dono do caso, caso o gato esteja com fome.
     * @param estaComFome recebe esta variável que indica se o gato está com fome.
     * @return indica se o gato deve ser alimentado ou se o mesmo está saciado.
     */
    public static String fome(boolean estaComFome) {
        return estaComFome ? "Alimentar o gato!" : "Saciado.";
    }

    /**
     * Esta classe instancia um objeto Gato, com suas características e ações.
     * @author Bruno Cunha
     * @param args
     */
    public static void main(String[] args) {
        Gato gato = new Gato("Vira-lata", 3, "Rajado", "Mingau");

        System.out.println(gato.miar());

        System.out.println(gato.fome(false));
    }
}