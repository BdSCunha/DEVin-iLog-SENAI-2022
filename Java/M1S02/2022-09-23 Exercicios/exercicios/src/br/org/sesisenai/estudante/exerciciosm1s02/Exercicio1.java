package br.org.sesisenai.estudante.exerciciosm1s02;

public class Exercicio1 {
    /*
     * DESCRIÇÃO:
     * Implemente um código copiando o array abaixo, e depois imprima no console o valor dos seguintes elementos:
     * int[] arr = { 56, 57, 58, 67, 99, 12, 11, 88 };
     */
    public static void main(String[] args) {
        int[] arr = { 56, 57, 58, 67, 99, 12, 11, 88 };

        // a) Imprima o valor do primeiro elemento;
        System.out.printf("Primeiro elemento do array: %d\n", arr[0]);

        // b) Imprima o valor do último elemento;
        System.out.printf("Ultimo elemento do array: %d\n", arr[arr.length - 1]);

        // c) Imprima o valor do terceiro elemento;
        System.out.printf("Terceiro elemento do array: %d\n", arr[2]);
    }
}
