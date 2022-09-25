package br.org.sesisenai.estudante.exerciciosm1s02;

public class Exercicio4 {
    /*
     * DESCRIÇÃO:
     * Mike tem um nro da sorte: 25.
     * Ele conseguiu uma listagem do histórico dos resultados da loteria conforme arrays abaixo.
     * Escreva um código para percorrer os elementos de nros sorteados e contabilizar quantas vezes o nro da sorte dele foi sorteado.
     * int sorteados[][] = {{ 1, 44,  6,  2, 45, 60}, {10, 21, 55, 25, 34, 44}, { 8, 18, 28, 29, 55, 59}, {60, 25, 11, 34,  6,  9}, {55, 43, 25, 12,  7, 11}};
     */
    public static void main(String[] args) {
        int sorteados[][] = {
            { 1, 44,  6,  2, 45, 60},
            {10, 21, 55, 25, 34, 44},
            { 8, 18, 28, 29, 55, 59},
            {60, 25, 11, 34,  6,  9},
            {55, 43, 25, 12,  7, 11}
        };

        int nroDaSorte = 25;
        int contador = 0;
        // * Dica: Usar um for dentro do outro para percorrer os arrays internos.
        for(int[] sorteio : sorteados) {
            for(int i = 0 ; i < sorteio.length ; i++) {
                if(sorteio[i] == nroDaSorte) contador++;
            }
        }

        System.out.printf("O numero da sorte %d foi sorteado %d vezes em %d sorteios.", nroDaSorte, contador, sorteados.length);
    }
}
