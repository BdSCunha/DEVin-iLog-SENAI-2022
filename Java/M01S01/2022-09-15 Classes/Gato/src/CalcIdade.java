import java.util.Scanner;
import java.time.LocalDate;

public class CalcIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ano do seu nascimento: ");
        int anoDeNascimento = scanner.nextInt();
        scanner.close();

        int anoAtual = LocalDate.now().getYear();

        int idade = anoAtual - anoDeNascimento;

        System.out.printf("Você tem %d anos.", idade);
    }
}
