package br.edu.labschool.model;

import java.time.LocalDate;

import br.edu.labschool.exception.CPFInvalidoException;
import br.edu.labschool.exception.PessoaException;
import br.edu.labschool.repository.PessoaRepository;
import br.edu.labschool.util.*;

public abstract class Pessoa {
    static Long contador = 0L;  // Contador que servirá de base para a criação dos Id's das Pessoas cadastradas

    String nome;
    Long telefone;
    LocalDate dataNascimento;
    Long cpf;
    Long id;

    public Pessoa(String nome, Long telefone, LocalDate dataNascimento, Long cpf) {
        for(Pessoa pessoa : PessoaRepository.getPessoas()) if(pessoa.getCpf().equals(cpf)) throw new IllegalArgumentException("Usuario ja cadastrado no sistema!");

        // Restrições dos atributos de objetos da classe Pessoa ou de classes filhas de Pessoa
        if(nome == null || telefone == null || telefone < 1000000000L || telefone > 99999999999L || dataNascimento == null) throw new PessoaException();
        else if(!ValidadorCPF.isValidCPF(cpf.toString())) throw new CPFInvalidoException();
        
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

    // Cdomo o CPF deve ser único, caso o CPF de dois objetos da classe Pessoa ou de classes filhas de Pessoa seja igual, os objetos podem ser considerados iguais, independentemente dos demais atributos
    @Override
    public boolean equals(Object obj) {
        if(obj == null || obj.getClass() != this.getClass()) return false;
        else if(((Pessoa)obj).getCpf() == this.getCpf()) return true;
        return false;
    }
}
