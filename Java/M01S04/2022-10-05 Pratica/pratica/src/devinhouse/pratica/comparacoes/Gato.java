package devinhouse.pratica.comparacoes;

import java.time.LocalDate;

public class Gato implements Comparable<Gato> {
    private String nome;
    private Integer idade;
    private LocalDate dataCadastro;

    public Gato(String nome, Integer idade, LocalDate dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.dataCadastro = dataNascimento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int compareTo(Gato o) {
        return this.getNome().compareTo(o.getNome());
        // return this.getIdade().compareTo(o.getIdade());

        // if (this.getIdade() > o.getIdade()) return 1;
        // else if (this.getIdade() < o.getIdade()) return -1;
        // else return 0;
    }

    @Override
    public String toString() {
        return "Gato [nome=" + nome + ", idade=" + idade + ", dataCadastro=" + dataCadastro + "]";
    }
}
