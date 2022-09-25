package br.org.sesisenai.estudante.exerciciosm1s02;

public class Exercicio10 {
    /*
     * Um palíndrome (ou palíndromo), segundo o dicionário Houaiss, "diz-se de frase ou palavra que se pode ler, indiferentemente, da esquerda para direita ou vice-versa", como por exemplo:  osso, ana, radar.
     * Ou seja, é uma palavra que quando lida de trás pra frente tem o mesmo significado.
     * 
     * Implemente um código com o que aprendemos até agora que retorne se determinada palavra é um palíndromo.
     */
    public static void main(String[] args) {
        String palavra = "anilina";

        String palavraInvertida = "";
        for(int i = palavra.length() - 1 ; i >= 0  ; i--) palavraInvertida +=  palavra.charAt(i);

        if(palavra.equals(palavraInvertida.toString())) {
            System.out.printf("A palavra \"%s\" É PALINDROMA", palavra);
        } else {
            System.out.printf("A palavra \"%s\" NAO É palindroma", palavra);
        }
    }
}
