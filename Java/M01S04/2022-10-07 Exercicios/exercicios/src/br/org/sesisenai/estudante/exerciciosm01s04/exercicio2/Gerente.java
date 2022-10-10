package br.org.sesisenai.estudante.exerciciosm01s04.exercicio2;

// c) Transforme a classe Gerente numa classe que não pode mais ser extendida (ou seja, que não pode ter subclasses).
public final class Gerente extends Funcionario {
    // b) Crie uma classe Gerente que herde de Funcionário, sobrescrevendo o método de obter cargo com o texto "Sou Gerente".
    @Override
    public final String obterCargo() {
        return "Sou Gerente";
    }
}
