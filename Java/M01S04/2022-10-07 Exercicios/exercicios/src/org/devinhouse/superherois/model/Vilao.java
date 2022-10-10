package org.devinhouse.superherois.model;

// Crie no projeto java as classes: - Vilao (subclasse de Personagem): atributo 'tempoDePrisao' (Integer)
public class Vilao extends Personagem {
    private Integer tempoDePrisao;

    public Vilao(String nome, String superpoder, Integer tempoDePrisao) {
        super(nome, superpoder);
        this.tempoDePrisao = tempoDePrisao;
    }

    public Integer getTempoDePrisao() {
        return tempoDePrisao;
    }

    @Override
    public String toString() {
        return "Vilao [nome=" + this.getNome() + ", superpoder=" + this.getSuperpoder() + ", tempoDePrisao=" + tempoDePrisao + "]";
    }
}
