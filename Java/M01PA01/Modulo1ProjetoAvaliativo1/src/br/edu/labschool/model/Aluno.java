package br.edu.labschool.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.edu.labschool.Main;
import br.edu.labschool.exception.CPFInvalidoException;
import br.edu.labschool.exception.OpcaoInvalidaException;
import br.edu.labschool.repository.PessoaRepository;
import br.edu.labschool.util.ValidadorCPF;

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
        System.out.println(Main.ANSI_YELLOW + "Lab School > CADASTRAMENTO > 1 - Cadastrar Aluno" + Main.ANSI_RESET);

        System.out.print("Digite o Nome do Aluno: ");
        String nome = scanner.nextLine();
        if(nome.isEmpty()) throw new IllegalArgumentException("O nome nao pode ser vazio!");

        System.out.print("Digite o telefone do Aluno (10 ou 11 algarismos, DDD + numero, sem o 0 inicial): ");
        Long telefone = Long.parseLong(scanner.nextLine());
        if(telefone < 1000000000L || telefone > 99999999999L) throw new IllegalArgumentException("O telefone deve ter 10 ou 11 algarismos!");

        System.out.print("Digite a Data de nascimento do Aluno (DD/MM/AAAA): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o CPF do Aluno (11 algarismos, sem pontos ou hifen): ");
        Long cpf = Long.parseLong(scanner.nextLine());
        if(!ValidadorCPF.isValidCPF(cpf.toString())) throw new CPFInvalidoException();

        StatusMatriculaAluno statusMatricula = StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO;

        System.out.print("Digite a nota do aluno (0 a 10): ");
        int nota = Integer.parseInt(scanner.nextLine());
        if(nota < 0 || nota > 10) throw new IllegalArgumentException("A nota deve estar entre 0 e 10!");

        Aluno aluno = new Aluno(nome, telefone, dataNascimento, cpf, statusMatricula, nota, 0);

        PessoaRepository.adicionarPessoa(aluno);

        System.out.printf(Main.ANSI_YELLOW + "\n%s cadastrado com sucesso!\n" + Main.ANSI_RESET, aluno.toString());

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void AtualizarStatusMatriculaAluno(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_CYAN + "Lab School > SERVICOS > 4 - Atualizar status matricula aluno" + Main.ANSI_RESET);

        System.out.print("Digite o CPF do aluno que tera a matricula alterada: ");
        Long cpf = Long.parseLong(scanner.nextLine());
        if(!ValidadorCPF.isValidCPF(cpf.toString())) throw new CPFInvalidoException();

        System.out.println("Digite a opcao do status da matricula: ");
        System.out.println("1 - Ativo");
        System.out.println("2 - Irregular");
        System.out.println("3 - Atendimento Pedagogico");
        System.out.println("4 - Inativo");

        int opcao = Integer.parseInt(scanner.nextLine());

        boolean flag = false;

        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                if(pessoa.getCpf().equals(cpf)) {
                    Aluno aluno = (Aluno)pessoa;
                    int id = pessoa.getId().intValue();

                    if(opcao == 1) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.ATIVO);
                    else if(opcao == 2) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.IRREGULAR);
                    else if(opcao == 3) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO);
                    else if(opcao == 4) aluno.setStatusMatricula(Aluno.StatusMatriculaAluno.INATIVO);
                    else throw new OpcaoInvalidaException();

                    PessoaRepository.pessoas.set(id, aluno);

                    System.out.printf(Main.ANSI_CYAN + "\nMatricula do %s alterada com sucesso!\n" + Main.ANSI_RESET, aluno.toString());

                    flag = true;
                    
                    break;
                }
            }
        }
        if(!flag) throw new IllegalArgumentException("CPF nao cadastrado no sistema ou nao cadastrado como Aluno!");

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void relatorioAlunos(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_MAGENTA + "Lab School > RELATORIOS > 7 - Relatorio de alunos" + Main.ANSI_RESET);

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

        int contador = 0;
        System.out.println(Main.ANSI_MAGENTA + "\nRELATORIO DE ALUNOS: ");
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                if(((Aluno)pessoa).getStatusMatricula().equals(statusMatricula) || opcao == 5) {
                    System.out.println("Id: " + pessoa.getId() + ", nome: " + pessoa.getNome() + ", nota: " + ((Aluno)pessoa).getNota() + ", atendimentosSolicitados: " + ((Aluno)pessoa).getAtendimentosSolicitados());

                    contador++;
                }
            }
        }
        System.out.println(Main.ANSI_RESET);

        if(contador == 0) System.out.printf(Main.ANSI_RED + "Nao ha nenhum Aluno cadastrado com a situacao de matricula selecionada: %s.\n" + Main.ANSI_RESET, statusMatricula);

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void relatorioAtendimentoPedagogico(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_MAGENTA + "Lab School > RELATORIOS > 9 - Relatorio de atendimento pedagogico dos Alunos" + Main.ANSI_RESET);

        List<Aluno> alunosList = new ArrayList<>();
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                alunosList.add(((Aluno)pessoa));
            }
        }
        Collections.sort(alunosList, new OrdernarAlunosPorAtendimentosSolicitados());

        System.out.println(Main.ANSI_MAGENTA + "\nRELATORIO DE ATENDIMENTO PEDAGOGICO DOS ALUNOS (ORDEM CRESCENTE): ");
        for(Aluno aluno : alunosList) {
            System.out.println("Id: " + aluno.getId() + ", nome: " + aluno.getNome() + ", atendimentosSolicitados: " + aluno.getAtendimentosSolicitados());
        }
        System.out.println(Main.ANSI_RESET);

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
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

class OrdernarAlunosPorAtendimentosSolicitados implements Comparator<Aluno> {
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a2.getAtendimentosSolicitados().compareTo(a1.getAtendimentosSolicitados());
    }
}
