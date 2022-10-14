package br.edu.labschool.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.repository.PessoaRepository;

public class Aluno extends Pessoa {
    public enum StatusMatriculaAluno {
        ATIVO,
        IRREGULAR,
        ATENDIMENTO_PEDAGOGICO,
        INATIVO;
    }

    private StatusMatriculaAluno statusMatricula;
    private Integer nota;
    private Integer atendimentosSolicitados = 0;

    public Aluno(String nome, Long telefone, LocalDate dataNascimento, Long cpf, StatusMatriculaAluno statusMatricula, Integer nota, Integer atendimentosSolicitados) {
        super(nome, telefone, dataNascimento, cpf);
        this.statusMatricula = statusMatricula;
        this.nota = nota;
        this.atendimentosSolicitados = atendimentosSolicitados;
    }

    public static void CadastrarAluno(Scanner scanner) {
        System.out.println();
        System.out.println("Lab School > 1 - Cadastrar Aluno");
        System.out.println("┌─┐┌─┐┌┬┐┌─┐┌─┐┌┬┐┬─┐┌─┐┬─┐  ┌─┐┬  ┬ ┬┌┐┌┌─┐");
        System.out.println("│  ├─┤ ││├─┤└─┐ │ ├┬┘├─┤├┬┘  ├─┤│  │ │││││ │");
        System.out.println("└─┘┴ ┴─┴┘┴ ┴└─┘ ┴ ┴└─┴ ┴┴└─  ┴ ┴┴─┘└─┘┘└┘└─┘");
        System.out.println("--------------------------------------------");

        System.out.print("Digite o Nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone do Aluno (10 ou 11 algarismos, DDD + numero, sem o 0 inicial): ");
        Long telefone = Long.parseLong(scanner.nextLine());

        System.out.print("Digite a Data de nascimento do Aluno (DD/MM/AAAA): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o CPF do Aluno (11 algarismos, sem pontos ou hifen): ");
        Long cpf = Long.parseLong(scanner.nextLine());

        StatusMatriculaAluno statusMatricula = StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO;

        System.out.print("Digite a nota do aluno (0 a 10): ");
        int nota = Integer.parseInt(scanner.nextLine());

        Aluno aluno = new Aluno(nome, telefone, dataNascimento, cpf, statusMatricula, nota, 1);

        PessoaRepository.adicionarPessoa(aluno);

        System.out.printf("\n%s cadastrado com sucesso!\n", aluno.toString());

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void AtualizarStatusMatriculaAluno(Scanner scanner) {
        System.out.println();
        System.out.println("Lab School > 4 - Atualizar status matricula aluno");
        System.out.println("┌─┐┌┬┐┬ ┬┌─┐┬  ┬┌─┐┌─┐┬─┐  ┌┬┐┌─┐┌┬┐┬─┐┬┌─┐┬ ┬┬  ┌─┐  ┌─┐┬  ┬ ┬┌┐┌┌─┐");
        System.out.println("├─┤ │ │ │├─┤│  │┌─┘├─┤├┬┘  │││├─┤ │ ├┬┘││  │ ││  ├─┤  ├─┤│  │ │││││ │");
        System.out.println("┴ ┴ ┴ └─┘┴ ┴┴─┘┴└─┘┴ ┴┴└─  ┴ ┴┴ ┴ ┴ ┴└─┴└─┘└─┘┴─┘┴ ┴  ┴ ┴┴─┘└─┘┘└┘└─┘");
        System.out.println("---------------------------------------------------------------------");

        System.out.print("Digite o CPF do aluno que tera a matricula alterada: ");
        Long cpf = Long.parseLong(scanner.nextLine());

        System.out.println("Digite a opcao do status da matricula: ");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento Pedagogico");
        System.out.println("4 - Inativo");

        int opcao = Integer.parseInt(scanner.nextLine());

        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                if(pessoa.getCpf().equals(cpf)) {
                    Aluno aluno = (Aluno)pessoa;
                    int id = pessoa.getId().intValue();

                    if(opcao == 1) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.ATIVO);
                    else if(opcao == 2) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.IRREGULAR);
                    else if(opcao == 3) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO);
                    else if(opcao == 4) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.INATIVO);

                    PessoaRepository.pessoas.set(id, aluno);
                }
            }
        }
    }

    public static void relatorioAlunos(Scanner scanner) {
        System.out.println();
        System.out.println("Lab School > 7 - Relatorio de alunos");
        System.out.println("┬─┐┌─┐┬  ┌─┐┌┬┐┌─┐┬─┐┬┌─┐  ┌─┐┬  ┬ ┬┌┐┌┌─┐┌─┐");
        System.out.println("├┬┘├┤ │  ├─┤ │ │ │├┬┘││ │  ├─┤│  │ │││││ │└─┐");
        System.out.println("┴└─└─┘┴─┘┴ ┴ ┴ └─┘┴└─┴└─┘  ┴ ┴┴─┘└─┘┘└┘└─┘└─┘");
        System.out.println("---------------------------------------------");

        System.out.println("Digite a opcao do status das matriculas dos alunos que serao listados: ");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento Pedagogico");
        System.out.println("4 - Inativo");
        System.out.println("5 - Todos");

        int opcao = Integer.parseInt(scanner.nextLine());

        StatusMatriculaAluno statusMatricula = null;
        if(opcao == 1) statusMatricula = Aluno.StatusMatriculaAluno.ATIVO;
        else if(opcao == 2) statusMatricula = Aluno.StatusMatriculaAluno.IRREGULAR;
        else if(opcao == 3) statusMatricula = Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO;
        else if(opcao == 4) statusMatricula = Aluno.StatusMatriculaAluno.INATIVO;
        else if(opcao == 5);
        else throw new OpcaoInvalidaException();

        System.out.println("\nALUNOS: ");
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                if(((Aluno)pessoa).getStatusMatricula().equals(statusMatricula) || opcao == 5) {
                    System.out.println("Id: " + pessoa.getId() + ", nome: " + pessoa.getNome() + ", nota: " + ((Aluno)pessoa).getNota() + ", atendimentosSolicitados: " + ((Aluno)pessoa).getAtendimentosSolicitados());
                }
            }
        }
    }

    public StatusMatriculaAluno getStatusMatricula() {
        return statusMatricula;
    }
    public void setStatusMatricula(StatusMatriculaAluno statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getAtendimentosSolicitados() {
        return atendimentosSolicitados;
    }

    public void setAtendimentosSolicitados(Integer atendimentosSolicitados) {
        this.atendimentosSolicitados = atendimentosSolicitados;
    }

    @Override
    public String toString() {
        return "Aluno [" + 
        "id: " + this.getId() + 
        ", nome: " + this.getNome() + 
        ", telefone: " + this.getTelefone() + 
        ", dataNascimento: " + this.getDataNascimento() + 
        ", cpf: " + this.getCpf() + 
        ", statusMatricula: " + this.getStatusMatricula() + 
        ", nota: " + this.getNota() + 
        ", atendimentosSolicitados: " + this.getAtendimentosSolicitados() + 
        "]";
    }
}
