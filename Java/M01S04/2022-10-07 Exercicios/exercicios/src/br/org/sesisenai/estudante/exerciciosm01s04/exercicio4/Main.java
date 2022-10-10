package br.org.sesisenai.estudante.exerciciosm01s04.exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // Escreva um código que pergunte ao usuário (pela linha de comando) sua idade.
            System.out.print("Digite sua idade: ");
            String entrada = scanner.nextLine();

            // Caso seja informado um valor negativo, zero ou maior que cem, lance uma exceção que seja capturada por um bloco de try-catch e imprima no console uma mensagem explicativa para o usuário, e a seguir repita a pergunta para o usuário até que seja informado um valor de idade válido. 
            try {
                int idade = Integer.valueOf(entrada);
                if(idade <= 0 || idade > 100) throw new IllegalArgumentException("Idade fora do intervalo válido - de 1 a 100 anos.");

                // Quando for informado uma idade válida, imprima no console a frase: "Olá, você tem xx anos de idade!"
                System.out.printf("Olá, você tem %d anos de idade!\n", idade);

                scanner.close();

                return;
            } catch (NumberFormatException e) {
                System.out.println("Valor informado invalido - nao numerico");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
