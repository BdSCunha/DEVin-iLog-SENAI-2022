package br.org.sesisenai.estudante.exerciciosm01s03.exercicio1;

// DESCRIÇÃO:
// Crie uma classe 'Funcionario' para representar um empregado de uma empresa, contendo os atributos cpf, nome completo e salário.
// Implemente também um método 'promover' que recebe como parâmetro um percentual (float), devendo o salário ser aumentado pelo percentual indicado no argumento do método.
// Crie e utilize um objeto desta classe para testar a implementação.

public class Funcionario {
    private Long cpf;
    private String nomeCompleto;
    private Double salario;

    public void promover(Double percentual) {
        this.salario *= (1 + percentual);
    }

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.salario = 1212.0;
        funcionario.promover(0.1);

        System.out.println(funcionario.salario);
    }
}
