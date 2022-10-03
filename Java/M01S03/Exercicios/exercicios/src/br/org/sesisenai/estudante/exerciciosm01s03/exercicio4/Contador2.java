package br.org.sesisenai.estudante.exerciciosm01s03.exercicio4;

import java.util.StringTokenizer;

// a) Crie uma classe 'Contador2'
public class Contador2 {
    // b) Crie um atributo privado 'frase' (String) nesta classe.
    private String frase;
    public String getFrase() {
        return frase;
    }

    // c) Implemente um construtor que receba uma frase como parâmetro, e inicialize o atributo criado com esta frase
    public Contador2(String frase) {
        this.frase = frase;
    }

    // d) Implemente um método (não static desta vez) 'contarPalavras' que retorna a quantidade de palavras da frase indicada no atributo da classe.
    public int contarPalavras() {
        StringTokenizer st = new StringTokenizer(this.getFrase(), " ");
        return st.countTokens();
    }
}
