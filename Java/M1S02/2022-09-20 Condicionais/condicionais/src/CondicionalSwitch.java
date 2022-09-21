public class CondicionalSwitch {
    public static void main(String[] args) {
        String cor = "dourado";

        switch(cor) {
            case "azul":
                System.out.println("Cor do céu!");
                break;
            case "verde":
                System.out.println("Cor das plantas!");
                break;
            case "dourado":
                System.out.println("Cor do ouro!");
                break;
            default:
                System.out.println("Outra cor!");
        }
    }
}
