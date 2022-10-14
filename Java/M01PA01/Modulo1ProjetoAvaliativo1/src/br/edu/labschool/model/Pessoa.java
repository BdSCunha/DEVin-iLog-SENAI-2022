package br.edu.labschool.model;

import java.time.LocalDate;

public abstract class Pessoa {
    static Long contador = 0L;

    String nome;
    Long telefone;
    LocalDate dataNascimento;
    Long cpf;
    Long id;

    public Pessoa(String nome, Long telefone, LocalDate dataNascimento, Long cpf) {
        this.id = contador++;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getCpf() {
        return cpf;
    }
}
