package org.devinhouse.superherois.model;

// Crie no projeto java as classes: Personagem (classe abstrata): atributos 'nome' e 'superpoder', ambas do tipo String;
public abstract class Personagem implements Comparable<Personagem> {
    private String nome, superpoder;

    public Personagem(String nome, String superpoder) {
        this.nome = nome;
        this.superpoder = superpoder;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public String getNome() {
        return nome;
    }

    // a) Implemente/sobrescreva o método 'equals()', identificando os personagens pelo nome, ou seja, são iguais se tem o mesmo nome.
    public boolean equals(Personagem p) {
        return this.getNome().equals(p.getNome()) ? true : false;
    }

    // b) Faça esta classe implementar a interface Comparable, comparando os personagens em ordem alfabética de nome.
    @Override
    public int compareTo(Personagem p) {
        return this.getNome().compareTo(p.getNome());
    }
}
