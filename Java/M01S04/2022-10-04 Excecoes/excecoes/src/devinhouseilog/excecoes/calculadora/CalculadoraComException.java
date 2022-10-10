package devinhouseilog.excecoes.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraComException {
    public static void main(String[] args) {
        try {
            System.out.print("Digite o primeiro numero - n1: ");
        
            Scanner scanner = new Scanner(System.in);
            double n1 = scanner.nextDouble();

            System.out.print("Digite o segundo numero - n2: ");
            double n2 = scanner.nextDouble();

            while(true) {
                System.out.println("\nDigite o numero da operacao a ser realizada com os numeros: ");
                System.out.println("1: Adicao (n1 + n2)");
                System.out.println("2: Subtracao (n1 - n2)");
                System.out.println("3: Multiplicacao (n1 * n2)");
                System.out.println("4: Divisao (n1 / n2)");

                int opcao = scanner.nextInt();

                Operacao operacao = null;

                if(opcao >= 1 && opcao <= 4) {
                    if(opcao == 1) operacao = new Adicao();
                    if(opcao == 2) operacao = new Subtracao();
                    if(opcao == 3) operacao = new Multiplicacao();
                    if(opcao == 4) operacao = new Divisao();

                    scanner.close();
                    System.out.printf("\n%s: n1 %s n2 = %.2f\n\n", operacao.getDescricao(), operacao.sinalOperacao(), operacao.calcular(n1, n2));
                    return;
                } else {
                    System.out.println("\nDIGITE UMA OPERACAO VALIDA!!!");
                    System.out.println("----------------------------------------");
                }
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("O valor digitado deve ser NUMÉRICO.");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Nao e possivel executar a operacao solicitada devido a alguma INDETERMINACAO");
        } catch (Exception e) {
            System.out.println("Algum erro indeterminado aconteceu. Favor reiniciar a aplicacao.");
        } finally {
            System.out.println("Operacao finalizada. Encerrando a aplicacao...\n");
        }
    }
}
