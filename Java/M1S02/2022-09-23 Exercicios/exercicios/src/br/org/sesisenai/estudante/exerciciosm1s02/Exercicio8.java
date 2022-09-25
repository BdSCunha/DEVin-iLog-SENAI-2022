package br.org.sesisenai.estudante.exerciciosm1s02;

import java.util.Arrays;
import java.util.List;

public class Exercicio8 {
    /*
     * Localize na lista abaixo e imprima no console a primeira ocorrência de número maior que 50.
     * List<Integer> numeros = Arrays.asList(0,2,88,56,33,42,67,3,9,0,2);
     */
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(0, 2, 88, 56, 33, 42, 67, 3, 9, 0, 2);

        for(Integer numero : numeros) {
            if(numero > 50) {
                System.out.println(numero);
                return;
            }
        }
    }
}
