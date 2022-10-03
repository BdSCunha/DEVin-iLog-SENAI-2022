package br.org.sesisenai.estudante.exerciciosm01s03.exercicio2;

// a) Crie uma classe 'Funcionario' com os atributos 'nome' (String) e 'salário' (Float).
public class Funcionario {
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    private Float salario;
    public Float getSalario() {
        return salario;
    }
    public void setSalario(Float salario) {
        this.salario = salario;
    }

    // b) Implemente um construtor que receba um argumento de nome e inicialize o atributo de 'nome' com este valor.
    public Funcionario(String nome) {
        this.nome = nome;
    }

    // c) Implemente outro construtor que receba como argumentos nome e salário e inicialize os respectivos atributos.
    public Funcionario(String nome, Float salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // d) Implemente um método público 'aumentar' que recebe como parâmetro um valor (Float). Na implementação, some este valor ao 'salário'.
    public void aumentar(Float aumento) {
        this.setSalario(this.getSalario() + aumento);
    }

    // e) Implemente outro método público 'aumentar' que recebe como parâmetros um valor (Float) e uma commissão (Float). Na implementação, some ambos os valores ao 'salário'.
    public void aumentar(Float aumento, Float comissao) {
        this.setSalario(this.getSalario() + aumento + comissao);
    }
}
