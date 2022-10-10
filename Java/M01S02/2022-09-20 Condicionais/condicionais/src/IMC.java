import java.util.Locale;
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);   // '.' como separador decimal

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu peso: ");
        float peso = scanner.nextFloat();

        System.out.print("Digite sua altura: ");
        float altura = scanner.nextFloat();

        scanner.close();

        double imc = peso / Math.pow(altura, 2);

        String classificacao; 

        if(imc < 18.5) {
            classificacao = "MAGREZA";
        } else if(imc < 25) {
            classificacao = "NORMAL";
        } else if(imc < 30 ) {
            classificacao = "SOBREPESO";
        } else if(imc < 40) {
            classificacao = "OBESIDADE";
        } else {
            classificacao = "OBESIDADE GRAVE";
        }

        System.out.printf("Seu IMC é %.2f e o resultado é: %s", imc, classificacao);
    }
}
