package org.devinhouse.superherois.model;

// Crie no projeto java as classes: - Heroi (subclasse de Personagem): atributo 'nomeVidaReal' (String)
public class Heroi extends Personagem {
    private String nomeVidaReal;

    public Heroi(String nome, String superpoder, String nomeVidaReal) {
        super(nome, superpoder);
        this.nomeVidaReal = nomeVidaReal;
    }

    public String getNomeVidaReal() {
        return nomeVidaReal;
    }

    @Override
    public String toString() {
        return "Heroi [nome=" + this.getNome() + ", superpoder=" + this.getSuperpoder() + ", nomeVidaReal=" + this.getNomeVidaReal() + "]";
    }
}
