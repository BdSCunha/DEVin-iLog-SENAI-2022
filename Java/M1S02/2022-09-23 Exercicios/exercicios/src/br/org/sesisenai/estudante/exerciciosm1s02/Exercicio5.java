package br.org.sesisenai.estudante.exerciciosm1s02;

import java.util.Arrays;

public class Exercicio5 {
    /*
     * Implemente uma função 'calcular' que receba como parâmetro um array (numérico) e identifique o maior e menor  valor do mesmo. Imprima no console estes valores ou "Não é possível calcular" qdo não for possível.
     * Teste a função com as seguintes entradas:
     * {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47}
     * {1}
     * {1, -1}
     * null
     * {-2,-2,-2,-2} 
     * {20,10, 30}
     */
    public static void main(String[] args) {
        Integer[][] testes = {
            {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47},
            {1},
            {1, -1},
            null,
            {-2, -2, -2, -2},
            {20, 10, 30},
            {null},
            {}
        };

        for(int i = 0 ; i < testes.length - 1 ; i++) {
            calcular(testes[i]);
        }
    }

    public static void calcular(Integer[] arr) {
        if(arr == null || arr.length == 0 || (arr.length == 1 && arr[0] == null)) {
            System.out.printf("Para o array %s: ", Arrays.toString(arr));
            System.out.println("Nao e possivel calcular");
            return;
        }

        Arrays.sort(arr);

        int min = arr[0];
        int max= arr[arr.length - 1];

        System.out.printf("Para o array %s o min é %d e o max é %d\n", Arrays.toString(arr), min, max);
    }
}
