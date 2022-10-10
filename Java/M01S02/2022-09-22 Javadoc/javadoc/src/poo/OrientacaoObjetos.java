package poo;

public class OrientacaoObjetos {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.saldo = 1000.0;

        Cliente cliente = new Cliente();
        cliente.nome = "Bruno";
        cliente.sobrenome = "Cunha";
        cliente.cpf = 32165498700L;

        conta.titular = cliente;

        conta.sacar(100.0);

        System.out.println(conta.saldo);
    }
}

class Cliente {
    String nome;
    String sobrenome;
    Long cpf;
}

class Conta {
    Cliente titular;
    double saldo;

    public void sacar(double valor) {
        double novoSaldo = this.saldo - valor;
        this.saldo = novoSaldo;
    }
}