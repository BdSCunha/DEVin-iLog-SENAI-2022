package br.org.sesisenai.estudante.exerciciosm1s02;

public class Exercicio3 {
    /*
     * DESCRIÇÃO:
     * Percorra um array com estrutura de repetição e faça operações com condicionais:
     * O array abaixo representa lançamentos na conta bancária do Luke.
     * Os valores negativos são débitos e os valores positivos são créditos.
     * Implemente um código copiando o array abaixo, e depois imprima no console o que se pede:
     * int[] extrato = { 100, -35, -15, -5, 55, -20 };
     */
    public static void main(String[] args) {
        int[] extrato = { 100, -35, -15, -5, 55, -20 };

        // a) Percorra o array (operador 'for') e imprima cada elemento do array na ordem
        for(int i = 0 ; i < extrato.length ; i++) {
            System.out.printf("extrato[%d]: %d\n", i, extrato[i]);
        }
        System.out.println();

        // b) Percorra o array (operador 'for') e imprima os elementos de trás pra frente (do último para o primeiro)
        for(int i = extrato.length - 1 ; i >= 0 ; i--) {
            System.out.printf("extrato[%d]: %d\n", i, extrato[i]);
        }
        System.out.println();

        // c) Percorra o array (operador 'for') e calcule o saldo final da conta (valor inicial era zero)
        int saldo = extrato[0];
        for(int i = 1 ; i < extrato.length ; i++) {
            saldo += extrato[i];
        }
        System.out.printf("Saldo final: %d\n", saldo);

        // d) Imprima no console a mensagem 'saldo positivo' ou 'saldo negativo', dependendo do resultado do saldo final calculado.
        String situacao = (saldo >= 0) ? "saldo positivo" : "saldo negativo";
        System.out.println(situacao);
    }
}
