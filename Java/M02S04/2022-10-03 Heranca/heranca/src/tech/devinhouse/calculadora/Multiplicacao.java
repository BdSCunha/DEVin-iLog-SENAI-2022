package tech.devinhouse.calculadora;

public class Multiplicacao implements Operacao {
    @Override
    public double calcular(double n1, double n2) {
        return n1*n2;
    }

    @Override
    public String getDescricao() {
        return "Multiplicacao";
    }
    
    @Override
    public String sinalOperacao() {
        return "*";
    }
}
