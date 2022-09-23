import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        List<Integer> opcao = new ArrayList<>();
        opcao.add(1);
        opcao.add(2);
        opcao.add(3);
        opcao.add(4);
        
        System.out.println("");
        for(Integer element:opcao) {
            System.out.printf("Opcao %o\n", element);
        }
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }
}
