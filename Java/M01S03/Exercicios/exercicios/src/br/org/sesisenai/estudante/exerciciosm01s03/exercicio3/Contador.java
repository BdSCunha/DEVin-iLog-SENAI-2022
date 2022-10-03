package br.org.sesisenai.estudante.exerciciosm01s03.exercicio3;

import java.util.StringTokenizer;

// a) Crie uma classe 'Contador'
public class Contador {
    // b) Crie um método estático (static) 'contarPalavras' que recebe uma frase (String) como argumento
    public static int contarPalavras(String frase) {
        StringTokenizer st = new StringTokenizer(frase, " ");
        return st.countTokens();
    }
}
