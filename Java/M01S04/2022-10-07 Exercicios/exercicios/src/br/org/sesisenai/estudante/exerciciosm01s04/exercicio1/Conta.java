package br.org.sesisenai.estudante.exerciciosm01s04.exercicio1;

// b) Crie a classe Abstrata Conta com o atributo "saldo" (double) e um método protegido (protected) "ObterSaldoAtual()".
public abstract class Conta {
    private double saldo;

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    protected double ObterSaldoAtual() {
        return this.getSaldo();
    }
}
