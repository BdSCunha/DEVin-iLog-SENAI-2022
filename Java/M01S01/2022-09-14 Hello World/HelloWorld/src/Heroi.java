import java.util.Scanner;

public class Heroi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de seu heroi favorito: ");
        String heroi = scanner.nextLine();
        scanner.close();

        System.out.printf("Seu heroi favorito e %s", heroi);
    }
}
