public class Ternario {
    public static void main(String[] args) {
        int idade = 18;
        String maiorDeIdade = idade >= 18 ? "Maior de idade." : "Menor de idade";
        System.out.println(maiorDeIdade);

        int numero = 89;
        String resultado = numero % 2 == 0 ? "Par" : "Impar";
        System.out.println(resultado);
    }
}
