package br.edu.labschool.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.labschool.Main;
import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.repository.PessoaRepository;

public class Professor extends Pessoa {
    private FormacaoProfessor formacaoProfessor;
    private ExperienciaProfessor experienciaProfessor;
    private StatusProfessor statusProfessor;

    public Professor(String nome, Long telefone, LocalDate dataNascimento, Long cpf, FormacaoProfessor formacaoProfessor, ExperienciaProfessor experienciaProfessor, StatusProfessor statusProfessor) {
        super(nome, telefone, dataNascimento, cpf);
        this.formacaoProfessor = formacaoProfessor;
        this.experienciaProfessor = experienciaProfessor;
        this.statusProfessor = statusProfessor;
    }

    public enum FormacaoProfessor {
        GRADUACAO_COMPLETA,
        GRADUACAO_INCOMPLETA,
        MESTRADO,
        DOUTORADO
    }

    public enum ExperienciaProfessor {
        FRONT_END,
        BACK_END,
        FULL_STACK
    }

    public enum StatusProfessor {
        ATIVO,
        INATIVO
    }

    public static void CadastrarProfessor(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_YELLOW + "Lab School > CADASTRAMENTO > 2 - Cadastrar Professor" + Main.ANSI_RESET);

        System.out.print("Digite o Nome do Professor: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone do Professor (10 ou 11 algarismos, DDD + numero, sem o 0 inicial): ");
        Long telefone = Long.parseLong(scanner.nextLine());

        System.out.print("Digite a Data de nascimento do Professor (DD/MM/AAAA): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o CPF do Professor (11 algarismos, sem pontos ou hifen): ");
        Long cpf = Long.parseLong(scanner.nextLine());

        // FORMACAO PROFESSOR
        System.out.println("Escolha abaixo uma opcao de formacao do Professor: ");
        System.out.println("1 - Graduacao Completa");
        System.out.println("2 - Graduacao Incompleta");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");

        int opcao = Integer.parseInt(scanner.nextLine());

        FormacaoProfessor formacaoProfessor;
        if(opcao == 1) formacaoProfessor = FormacaoProfessor.GRADUACAO_COMPLETA;
        else if(opcao == 2) formacaoProfessor = FormacaoProfessor.GRADUACAO_INCOMPLETA;
        else if(opcao == 3) formacaoProfessor = FormacaoProfessor.MESTRADO;
        else if(opcao == 4) formacaoProfessor = FormacaoProfessor.DOUTORADO;
        else throw new OpcaoInvalidaException();

        // EXPERIENCIA PROFESSOR
        System.out.println("Escolha abaixo uma opcao de experiencia do Professor: ");
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full Stack");

        opcao = Integer.parseInt(scanner.nextLine());

        ExperienciaProfessor experienciaProfessor;
        if(opcao == 1) experienciaProfessor = ExperienciaProfessor.FRONT_END;
        else if(opcao == 2) experienciaProfessor = ExperienciaProfessor.BACK_END;
        else if(opcao == 3) experienciaProfessor = ExperienciaProfessor.FULL_STACK;
        else throw new OpcaoInvalidaException();

        StatusProfessor statusProfessor = StatusProfessor.ATIVO;

        Professor professor = new Professor(nome, telefone, dataNascimento, cpf, formacaoProfessor, experienciaProfessor, statusProfessor);

        PessoaRepository.adicionarPessoa(professor);

        System.out.printf("\n%s cadastrado com sucesso!\n", professor.toString());

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void relatorioProfessores(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_MAGENTA + "Lab School > RELATORIOS > 8 - Relatorio de professores" + Main.ANSI_RESET);

        System.out.println("Digite a opcao de experiencia dos professores que serao listados: ");
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full Stack");
        System.out.println("4 - Todos");

        int opcao = Integer.parseInt(scanner.nextLine());

        ExperienciaProfessor experienciaProfessor = null;
        if(opcao == 1) experienciaProfessor = Professor.ExperienciaProfessor.FRONT_END;
        else if(opcao == 2) experienciaProfessor = Professor.ExperienciaProfessor.BACK_END;
        else if(opcao == 3) experienciaProfessor = Professor.ExperienciaProfessor.FULL_STACK;
        else if(opcao == 4);
        else throw new OpcaoInvalidaException();

        System.out.println("\nPROFESSORES: ");
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Professor) {
                if(((Professor)pessoa).getExperienciaProfessor().equals(experienciaProfessor) || opcao == 4) {
                    System.out.println("Id: " + pessoa.getId() + ", nome: " + pessoa.getNome() + ", formacaoProfessor: " + ((Professor)pessoa).getFormacaoProfessor() + ", experienciaProfessor: " + ((Professor)pessoa).getExperienciaProfessor() + ", statusProfessor: " + ((Professor)pessoa).getStatusProfessor());
                }
            }
        }
    }

    public FormacaoProfessor getFormacaoProfessor() {
        return formacaoProfessor;
    }
    public void setFormacaoProfessor(FormacaoProfessor formacaoProfessor) {
        this.formacaoProfessor = formacaoProfessor;
    }

    public ExperienciaProfessor getExperienciaProfessor() {
        return experienciaProfessor;
    }
    public void setExperienciaProfessor(ExperienciaProfessor experienciaProfessor) {
        this.experienciaProfessor = experienciaProfessor;
    }

    public StatusProfessor getStatusProfessor() {
        return statusProfessor;
    }
    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }

    @Override
    public String toString() {
        return "Professor [" + 
        "id: " + this.getId() + 
        ", nome: " + this.getNome() + 
        ", telefone: " + this.getTelefone() + 
        ", dataNascimento: " + this.getDataNascimento() + 
        ", cpf: " + this.getCpf() + 
        ", formacaoProfessor: " + this.getFormacaoProfessor() + 
        ", experienciaProfessor: " + this.getExperienciaProfessor() + 
        ", statusProfessor: " + this.getStatusProfessor() + 
        "]";
    }
}
