package br.org.sesisenai.estudante.exerciciosm01s04.exercicio3;

// b) Crie uma classe chamada "Produto" que implemente esta interface criada anteriormente.
public class Produto implements Tributavel {
    // Nesta classe crie os atributos "valor" e "valor imposto", ambos double.
    private double valor, valorImposto;

    // No método herdado, retorne a soma dos atributos de valores.
    @Override
    public double calcularValorComImposto() {
        return this.valor + this.valorImposto;
    }
}
