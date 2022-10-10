package br.org.sesisenai.estudante.exerciciosm1s02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio6 {
    /*
     * Dado a lista de números:
     * List<Integer> lista = Arrays.asList(1,2,3,4);
     * Percorra a lista e gere uma nova com o triplo do valor de cada elemento:
     */
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 2, 3, 4);

        List<Integer> triplos = new ArrayList<>();

        for(Integer nro : lista) {
            triplos.add(nro*3);
        }
        System.out.println(triplos);
    }
}
