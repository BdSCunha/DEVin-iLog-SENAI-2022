public class Arrays {
    public static void main(String[] args) {
        String[] cores = {"vermelho", "preto", "branco", "roxo", "azul", "amarelo"};
        System.out.println(cores.length);
        System.out.println(cores[2]);
        System.out.println(cores[0]);
        System.out.println(cores[cores.length - 1]);

        System.out.println();

        String[][] multicores = {
            {"vermelho", "preto", "branco"},
            {"roxo", "azul"}
        };
        System.out.println(multicores[0][0]);
        System.out.println(multicores[1][0]);
        System.out.println(multicores.length);
        System.out.println(multicores[0].length);
    }
}