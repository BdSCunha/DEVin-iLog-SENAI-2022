package br.edu.labschool;

import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import br.edu.labschool.cli.Display;
import br.edu.labschool.exception.CPFInvalidoException;
import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.exception.PessoaException;
import br.edu.labschool.model.Aluno;
import br.edu.labschool.model.Professor;
import br.edu.labschool.model.Pedagogo;
import br.edu.labschool.repository.PessoaRepository;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                Display.menuPrincipal();

                String entrada = scanner.nextLine();

                int opcao = Integer.parseInt(entrada);

                // CADASTRAMENTO
                if(opcao == 1) Aluno.CadastrarAluno(scanner);
                else if(opcao == 2) Professor.CadastrarProfessor(scanner);
                else if(opcao == 3) Pedagogo.CadastrarPedagogo(scanner);

                // SERVICOS
                else if(opcao == 4) Aluno.AtualizarStatusMatriculaAluno(scanner);
                else if(opcao == 5) Pedagogo.atendimentoPedagogico(scanner);

                // RELATORIOS
                else if(opcao == 6) PessoaRepository.relatorioPessoas(scanner);
                else if(opcao == 7) Aluno.relatorioAlunos(scanner);
                else if(opcao == 8) Professor.relatorioProfessores(scanner);
                else if(opcao == 9) Aluno.relatorioAtendimentoPedagogico(scanner);
                else if(opcao == 10) Pedagogo.relatorioAtendimentoPedagogico(scanner);

                // ENCERRAR SISTEMA
                else if(opcao == 11) {
                    System.out.println(ANSI_RED + "\nEncerrando aplicacao...\n" + ANSI_RESET);
                    return;
                }
                else throw new OpcaoInvalidaException();
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nFormato INVALIDO: o valor digitado deve ser NUMERICO. Selecione uma opcao valida para continuar.\n" + ANSI_RESET);
            } catch (OpcaoInvalidaException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nOpcao INVALIDA. Selecione uma opcao valida para continuar.\n" + ANSI_RESET);
            } catch (PessoaException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nAtributo(s) invalido(s) para criacao de um Aluno, Professor ou Pedagogo. Favor checar informacoes para prosseguir com cadastro...\n" + ANSI_RESET);
            } catch (DateTimeParseException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nA data de nascimento deve ser informada no formato DD/MM/AAAA\n" + ANSI_RESET);
            } catch (CPFInvalidoException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nServico nao finalizado: CPF INVALIDO!\n" + ANSI_RESET);
            } catch (NoSuchElementException e) {
                System.out.println(ANSI_RED + "\nEncerrando aplicacao...\n" + ANSI_RESET);
                return;
            } catch (IllegalArgumentException e) {
                System.out.printf(ANSI_RED_BACKGROUND + "\n%s Selecione uma opcao valida para continuar.\n" + ANSI_RESET, e.getMessage());
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "%s: %s. Selecione uma opcao valida para continuar.\n" + ANSI_RESET, e, e.getMessage());
            }
        }
    }
}
