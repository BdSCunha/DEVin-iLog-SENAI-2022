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
import br.edu.labschool.model.Aluno.StatusMatriculaAluno;
import br.edu.labschool.repository.PessoaRepository;
import br.edu.labschool.util.ValidadorCPF;

public class Pedagogo extends Pessoa {
    private Integer atendimentosRealizados = 0;

    public Pedagogo(String nome, Long telefone, LocalDate dataNascimento, Long cpf) {
        super(nome, telefone, dataNascimento, cpf);
    }

    public static void CadastrarPedagogo(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_YELLOW + "Lab School > CADASTRAMENTO > 3 - Cadastrar Pedagogo" + Main.ANSI_RESET);

        System.out.print("Digite o Nome do Pedagogo: ");
        String nome = scanner.nextLine();
        if(nome.isEmpty()) throw new IllegalArgumentException("O nome nao pode ser vazio!");

        System.out.print("Digite o telefone do Pedagogo (10 ou 11 algarismos, DDD + numero, sem o 0 inicial): ");
        Long telefone = Long.parseLong(scanner.nextLine());
        if(telefone < 1000000000L || telefone > 99999999999L) throw new IllegalArgumentException("O telefone deve ter 10 ou 11 algarismos!");

        System.out.print("Digite a Data de nascimento do Pedagogo (DD/MM/AAAA): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o CPF do Pedagogo (11 algarismos, sem pontos ou hifen): ");
        Long cpf = Long.parseLong(scanner.nextLine());
        if(!ValidadorCPF.isValidCPF(cpf.toString())) throw new CPFInvalidoException();

        Pedagogo pedagogo = new Pedagogo(nome, telefone, dataNascimento, cpf);

        PessoaRepository.adicionarPessoa(pedagogo);

        System.out.printf(Main.ANSI_YELLOW + "\n%s cadastrado com sucesso!\n" + Main.ANSI_RESET, pedagogo.toString());

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void atendimentoPedagogico(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_CYAN + "Lab School > SERVICOS > 5 - Atendimento Pedagogico" + Main.ANSI_RESET);

        System.out.print("Digite o CPF do Aluno que recebeu atendimento pedagogico: ");
        Long cpfAluno = Long.parseLong(scanner.nextLine());
        if(!ValidadorCPF.isValidCPF(cpfAluno.toString())) throw new CPFInvalidoException();

        System.out.print("Digite o CPF do Pedagogo que realizou o atendimento pedagogico: ");
        Long cpfPedagogo = Long.parseLong(scanner.nextLine());
        if(!ValidadorCPF.isValidCPF(cpfPedagogo.toString())) throw new CPFInvalidoException();

        Aluno aluno = null;
        Pedagogo pedagogo = null;
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno && pessoa.getCpf().equals(cpfAluno)) aluno = (Aluno)pessoa;
            else if(pessoa instanceof Pedagogo && pessoa.getCpf().equals(cpfPedagogo)) pedagogo = (Pedagogo)pessoa;
        }

        if(aluno != null && pedagogo != null) {
            int idAluno = aluno.getId().intValue();
            aluno.setAtendimentosSolicitados(aluno.getAtendimentosSolicitados() + 1);
            aluno.setStatusMatricula(StatusMatriculaAluno.ATENDIMENTO_PEDAGOGICO);
            PessoaRepository.pessoas.set(idAluno, aluno);
            
            int idPedagogo = pedagogo.getId().intValue();
            pedagogo.setAtendimentosRealizados(pedagogo.getAtendimentosRealizados() + 1);
            PessoaRepository.pessoas.set(idPedagogo, pedagogo);

            System.out.printf(Main.ANSI_CYAN + "\nAtendimento pedagogico entre o %s e o %s executado com sucesso!\n" + Main.ANSI_RESET, aluno.toString(), pedagogo.toString());
        } else throw new IllegalArgumentException("Nao foi possivel concluir o atendimento pedagogico. Favor checar informacoes para prosseguir com o atendimento...");

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void relatorioAtendimentoPedagogico(Scanner scanner) {
        System.out.println();
        System.out.println(Main.ANSI_MAGENTA + "Lab School > RELATORIOS > 10 - Relatorio de atendimento pedagogico dos Pedagogos" + Main.ANSI_RESET);

        List<Pedagogo> pedagogosList = new ArrayList<>();
        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Pedagogo) {
                pedagogosList.add(((Pedagogo)pessoa));
            }
        }
        Collections.sort(pedagogosList, new OrdernarPedagogosPorAtendimentosRealizados());

        System.out.println(Main.ANSI_MAGENTA + "\nRELATORIO DE ATENDIMENTO PEDAGOGICO DOS PEDAGOGOS (ORDEM CRESCENTE): ");
        for(Pedagogo pedagogo : pedagogosList) {
            System.out.println("Id: " + pedagogo.getId() + ", nome: " + pedagogo.getNome() + ", atendimentosRealizados: " + pedagogo.getAtendimentosRealizados());
        }
        System.out.println(Main.ANSI_RESET);

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public Integer getAtendimentosRealizados() {
        return atendimentosRealizados;
    }
    public void setAtendimentosRealizados(Integer atendimentosRealizados) {
        this.atendimentosRealizados = atendimentosRealizados;
    }

    @Override
    public String toString() {
        return "Pedagogo [" + 
        "id: " + this.getId() + 
        ", nome: " + this.getNome() + 
        ", telefone: " + this.getTelefone() + 
        ", dataNascimento: " + this.getDataNascimento() + 
        ", cpf: " + this.getCpf() + 
        ", atendimentosRealizados: " + this.getAtendimentosRealizados() + 
        "]";
    }
}

class OrdernarPedagogosPorAtendimentosRealizados implements Comparator<Pedagogo> {
    @Override
    public int compare(Pedagogo p1, Pedagogo p2) {
        return p2.getAtendimentosRealizados().compareTo(p1.getAtendimentosRealizados());
    }
}
