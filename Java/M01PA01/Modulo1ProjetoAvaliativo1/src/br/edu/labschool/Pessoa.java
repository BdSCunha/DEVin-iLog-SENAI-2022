package br.edu.labschool;

import java.time.LocalDate;

public abstract class Pessoa {
    String nome;
    Long telefone;
    LocalDate dataNascimento;
    Long cpf;
    static Long id;
}
