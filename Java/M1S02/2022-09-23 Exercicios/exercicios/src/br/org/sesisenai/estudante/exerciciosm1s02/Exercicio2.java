package br.org.sesisenai.estudante.exerciciosm1s02;

public class Exercicio2 {
    /*
     * DESCRIÇÃO:
     * Implemente um código copiando o array abaixo, e depois imprima no console o valor dos seguintes elementos:
     * double[][] notas = {{10, 8.5, 5.5, 9.5}, {8.5, 7, 7.5, 6}, {8, 9, 10, 7.5}, {9, 9.5, 10, 8}};
     */
    public static void main(String[] args) {
        double[][] notas = {
            {10, 8.5, 5.5, 9.5},
            {8.5, 7, 7.5, 6},
            {8, 9, 10, 7.5},
            {9, 9.5, 10, 8}
        };

        // a) Imprima o valor da nota do primeiro elemento do terceiro array de notas.
        System.out.printf("Primeiro elemento do terceiro array de notas ( n[2][0] ): %f\n", notas[2][0]);

        // b) Imprima o valor da nota do segundo elemento do quarto array de notas.
        System.out.printf("Segundo elemento do quarto array de notas ( notas[3][1] ): %f\n", notas[3][1]);

        // c) Imprima o valor da soma das quatro primeiras notas de cada array.
        for(int i = 0 ; i < notas.length ; i++) {
            double soma = 0;
            for(int j = 0 ; j < 3 ; j++) {
                soma += notas[i][j];
            }
            System.out.printf("Soma das quatro primeiras notas do array %d ( n[%d][0] + n[%d][1] + n[%d][2] + n[%d][3] ): %f\n", i, i, i, i, i, soma);
        }
    }
}
