package br.edu.labschool;

import java.time.LocalDate;
import java.util.Scanner;

import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.model.Aluno;
import br.edu.labschool.model.Professor;
import br.edu.labschool.repository.PessoaRepository;
import br.edu.labschool.model.Pedagogo;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        popularLista();

        while(true) {
            try {
                menu();
                String entrada = scanner.nextLine();
                int opcao = Integer.parseInt(entrada);

                if(opcao == 1) Aluno.CadastrarAluno(scanner);
                else if(opcao == 2) Professor.CadastrarProfessor(scanner);
                else if(opcao == 3) Pedagogo.CadastrarPedagogo(scanner);
                else if(opcao == 4) Aluno.AtualizarStatusMatriculaAluno(scanner);
                else if(opcao == 5) Pedagogo.realizarAtendimentoPedagogico(scanner);
                else if(opcao == 6) PessoaRepository.listarPessoas(scanner);
                else if(opcao == 7) Aluno.relatorioAlunos(scanner);
                else if(opcao == 8) Professor.relatorioProfessores(scanner);
                // "9 - Relatorio de atendimento pedagogico dos Alunos");
                // "10 - Relatorio de atendimento pedagogico dos Pedagogos");
                else if(opcao == 11) {
                    System.out.println("Encerrando aplicacao...\n");
                    return;
                }
                else throw new OpcaoInvalidaException();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nFormato INVALIDO: o valor digitado deve ser NUMERICO. Selecione uma opcao valida para continuar.\n" + ANSI_RESET);
            } catch (OpcaoInvalidaException e) {
                System.out.println(ANSI_RED + "\nOpcao INVALIDA. Selecione uma opcao valida para continuar.\n" + ANSI_RESET);
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "Alguma excecao ocorreu: %s. Selecione uma opcao valida para continuar.\n\n" + ANSI_RESET, e.getMessage());
            }
        }
    }

    public static void menu() {
        System.out.println(ANSI_GREEN);
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.println("║  ╔═╗╦╔═╗╔╦╗╔═╗╔╦╗╔═╗  ╦  ╔═╗╔╗   ╔═╗╔═╗╦ ╦╔═╗╔═╗╦    ║");
        System.out.println("║  ╚═╗║╚═╗ ║ ║╣ ║║║╠═╣  ║  ╠═╣╠╩╗  ╚═╗║  ╠═╣║ ║║ ║║    ║");
        System.out.println("║  ╚═╝╩╚═╝ ╩ ╚═╝╩ ╩╩ ╩  ╩═╝╩ ╩╚═╝  ╚═╝╚═╝╩ ╩╚═╝╚═╝╩═╝  ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.print(ANSI_RESET);
        System.out.println("1 - Cadastrar Aluno");
        System.out.println("2 - Cadastrar Professor");
        System.out.println("3 - Cadastrar Pedagogo");
        System.out.println("4 - Atualizar status matricula aluno");
        System.out.println("5 - Realizar atendimento pedagógico");
        System.out.println("6 - Listar Pessoas (Alunos, Professores e/ou Pedagogos)");
        System.out.println("7 - Relatorio de Alunos");
        System.out.println("8 - Relatorio de Professores");
        System.out.println("9 - Relatorio de atendimento pedagogico dos Alunos");
        System.out.println("10 - Relatorio de atendimento pedagogico dos Pedagogos");
        System.out.println("11 - Sair / Encerrar aplicacao");
    }

    public static void popularLista() {
        PessoaRepository.adicionarPessoa(new Aluno("Emily Santos Castro", 2777995249L, LocalDate.of(1947, 8, 27), 67542338854L, Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO, 8, 1));
        PessoaRepository.adicionarPessoa(new Aluno("Kaua Lima Dias", 4439843886L, LocalDate.of(1953, 2, 21), 83148347501L, Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO, 8, 1));
        PessoaRepository.adicionarPessoa(new Aluno("Renan Dias Cunha", 1459357247L, LocalDate.of(2001, 7, 22), 31937410943L, Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO, 8, 1));
        
        PessoaRepository.adicionarPessoa(new Professor("Sebastian Wexler", 8676157705L, LocalDate.of(1985, 10, 20), 18489100454L, Professor.FormacaoProfessor.MESTRADO, Professor.ExperienciaProfessor.FULL_STACK, Professor.StatusProfessor.ATIVO));
        PessoaRepository.adicionarPessoa(new Professor("Christian Capon", 6986336409L, LocalDate.of(1972, 5, 5), 49413320918L, Professor.FormacaoProfessor.GRADUACAO_COMPLETA, Professor.ExperienciaProfessor.BACK_END, Professor.StatusProfessor.ATIVO));
        PessoaRepository.adicionarPessoa(new Professor("Yuan Ho", 4239925636L, LocalDate.of(1962, 2, 1), 69772273705L, Professor.FormacaoProfessor.DOUTORADO, Professor.ExperienciaProfessor.FRONT_END, Professor.StatusProfessor.INATIVO));

        PessoaRepository.adicionarPessoa(new Pedagogo("Melissa Oliveira Martins", 2288652963L, LocalDate.of(1968, 4, 7), 63773741278L));
        PessoaRepository.adicionarPessoa(new Pedagogo("Erick Lima Ferreira", 1958637313L, LocalDate.of(2003, 9, 22), 91944944443L));
        PessoaRepository.adicionarPessoa(new Pedagogo("Douglas Ribeiro Dias", 6261612436L, LocalDate.of(1958, 12, 8), 43367098744L));
    }
}
