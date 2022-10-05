package devinhouseilog.excecoes.calculadora;

public class Divisao implements Operacao {
    @Override
    public double calcular(double n1, double n2) {
        return n1/n2;
    }

    @Override
    public String getDescricao() {
        return "Divisao";
    }
    
    @Override
    public String sinalOperacao() {
        return "/";
    }
}
