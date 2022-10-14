package br.edu.labschool.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.model.Aluno;
import br.edu.labschool.model.Pedagogo;
import br.edu.labschool.model.Pessoa;
import br.edu.labschool.model.Professor;

public class PessoaRepository {
    public static List<Pessoa> pessoas = new ArrayList<>();

    public static void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public static void listarPessoas(Scanner scanner) {
        if(PessoaRepository.getPessoas().isEmpty()) System.out.println("No momento nao ha nenhuma pessoa cadastrada no sistema.");
        else {
            System.out.println("Lab School > 6 - Listar Pessoas");
            System.out.println("┬  ┬┌─┐┌┬┐┌─┐┬─┐  ┌─┐┌─┐┌─┐┌─┐┌─┐┌─┐┌─┐");
            System.out.println("│  │└─┐ │ ├─┤├┬┘  ├─┘├┤ └─┐└─┐│ │├─┤└─┐");
            System.out.println("┴─┘┴└─┘ ┴ ┴ ┴┴└─  ┴  └─┘└─┘└─┘└─┘┴ ┴└─┘");
            System.out.println("---------------------------------------");
            System.out.println("Escolha abaixo uma opcao para listar as Pessoas cadastradas no sistema: ");
            System.out.println("1 - Listar Alunos");
            System.out.println("2 - Listar Professores");
            System.out.println("3 - Listar Pedagogos");
            System.out.println("4 - Listar todas as Pessoas");

            int opcao = Integer.parseInt(scanner.nextLine());

            if(opcao == 1) {
                System.out.println("\nListando Alunos:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Aluno) System.out.println(pessoa);
            } else if(opcao == 2) {
                System.out.println("\nListando Professores:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Professor) System.out.println(pessoa);
            } else if(opcao == 3) {
                System.out.println("\nListando Pedagogos:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Pedagogo) System.out.println(pessoa);
            } else if(opcao == 4) {
                System.out.println("\nListando todas as Pessoas:");
                for (Pessoa pessoa : PessoaRepository.getPessoas()) System.out.println(pessoa);
            } else throw new OpcaoInvalidaException();
        }
    }

    public static List<Pessoa> getPessoas() {
        return pessoas;
    }
    public static void setPessoas(List<Pessoa> pessoas) {
        PessoaRepository.pessoas = pessoas;
    }

    @Override
    public String toString() {
        System.out.println("Lab School > 6 - Lista pessoas");
        return "PessoaRepository []";
    }
}
