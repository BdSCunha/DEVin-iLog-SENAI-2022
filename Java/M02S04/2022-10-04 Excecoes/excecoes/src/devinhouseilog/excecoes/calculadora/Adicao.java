package devinhouseilog.excecoes.calculadora;

public class Adicao implements Operacao {
    @Override
    public double calcular(double n1, double n2) {
        return n1 + n2;
    }

    @Override
    public String getDescricao() {
        return "Adicao";
    }
    
    @Override
    public String sinalOperacao() {
        return "+";
    }
}
