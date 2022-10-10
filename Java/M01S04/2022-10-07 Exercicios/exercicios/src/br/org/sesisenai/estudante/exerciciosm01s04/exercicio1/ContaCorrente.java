package br.org.sesisenai.estudante.exerciciosm01s04.exercicio1;

// c) Crie uma classe "ContaCorrente" que implemente a interface Operavel e herde da classe Conta. Faça uma implementação dos métodos herdados.
public class ContaCorrente extends Conta implements Operavel {
    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void sacar(double valor) {
        this.setSaldo(this.getSaldo() - valor);
    }
}
