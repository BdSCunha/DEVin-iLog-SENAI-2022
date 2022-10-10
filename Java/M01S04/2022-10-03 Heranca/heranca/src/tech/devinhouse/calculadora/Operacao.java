package tech.devinhouse.calculadora;

public interface Operacao {
    double calcular(double n1, double n2);
    String getDescricao();
    String sinalOperacao();
}
