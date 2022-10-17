package br.edu.labschool.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.labschool.Main;
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

    public static void relatorioPessoas(Scanner scanner) {
        if(PessoaRepository.getPessoas().isEmpty()) System.out.println(Main.ANSI_RED + "No momento nao ha nenhuma pessoa cadastrada no sistema." + Main.ANSI_RESET);
        else {
            System.out.println(Main.ANSI_MAGENTA + "Lab School > SERVICOS > 6 - Listar Pessoas" + Main.ANSI_RESET);
            System.out.println("Escolha abaixo uma opcao para listar as Pessoas cadastradas no sistema: ");
            System.out.println("1 - Listar Alunos");
            System.out.println("2 - Listar Professores");
            System.out.println("3 - Listar Pedagogos");
            System.out.println("4 - Listar todas as Pessoas");

            int opcao = Integer.parseInt(scanner.nextLine());

            System.out.println(Main.ANSI_MAGENTA);
            if(opcao == 1) {
                System.out.println("LISTANDO ALUNOS:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Aluno) System.out.println(pessoa);
            } else if(opcao == 2) {
                System.out.println("LISTANDO PROFESSORES:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Professor) System.out.println(pessoa);
            } else if(opcao == 3) {
                System.out.println("LISTANDO PEDAGOGOS:");
                for (Pessoa pessoa : pessoas) if(pessoa instanceof Pedagogo) System.out.println(pessoa);
            } else if(opcao == 4) {
                System.out.println("LISTANDO TODAS AS PESSOAS:");
                for (Pessoa pessoa : PessoaRepository.getPessoas()) System.out.println(pessoa);
            } else {
                System.out.println(Main.ANSI_RESET);
                throw new OpcaoInvalidaException();
            }
            System.out.println(Main.ANSI_RESET);
        }

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static List<Pessoa> getPessoas() {
        return pessoas;
    }
}
