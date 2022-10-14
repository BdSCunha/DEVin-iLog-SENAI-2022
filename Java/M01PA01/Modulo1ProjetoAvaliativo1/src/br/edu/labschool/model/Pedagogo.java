package br.edu.labschool.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.edu.labschool.repository.PessoaRepository;

public class Pedagogo extends Pessoa {
    private Integer atendimentosRealizados = 0;

    public Pedagogo(String nome, Long telefone, LocalDate dataNascimento, Long cpf) {
        super(nome, telefone, dataNascimento, cpf);
    }

    public static void CadastrarPedagogo(Scanner scanner) {
        System.out.println();
        System.out.println("Lab School > 3 - Cadastrar Pedagogo");
        System.out.println("┌─┐┌─┐┌┬┐┌─┐┌─┐┌┬┐┬─┐┌─┐┬─┐  ┌─┐┌─┐┌┬┐┌─┐┌─┐┌─┐┌─┐┌─┐");
        System.out.println("│  ├─┤ ││├─┤└─┐ │ ├┬┘├─┤├┬┘  ├─┘├┤  ││├─┤│ ┬│ ││ ┬│ │");
        System.out.println("└─┘┴ ┴─┴┘┴ ┴└─┘ ┴ ┴└─┴ ┴┴└─  ┴  └─┘─┴┘┴ ┴└─┘└─┘└─┘└─┘");
        System.out.println("-----------------------------------------------------");

        System.out.print("Digite o Nome do Pedagogo: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o telefone do Pedagogo (10 ou 11 algarismos, DDD + numero, sem o 0 inicial): ");
        Long telefone = Long.parseLong(scanner.nextLine());

        System.out.print("Digite a Data de nascimento do Pedagogo (DD/MM/AAAA): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite o CPF do Pedagogo (11 algarismos, sem pontos ou hifen): ");
        Long cpf = Long.parseLong(scanner.nextLine());

        Pedagogo pedagogo = new Pedagogo(nome, telefone, dataNascimento, cpf);

        PessoaRepository.adicionarPessoa(pedagogo);

        System.out.printf("\n%s cadastrado com sucesso!\n", pedagogo.toString());

        System.out.println("\nPressione ENTER para prosseguir...");
        scanner.nextLine();
    }

    public static void realizarAtendimentoPedagogico(Scanner scanner) {
        System.out.println();
        System.out.println("Lab School > 5 - Atendimento Pedagogico");
        System.out.println("┌─┐┌┬┐┌─┐┌┐┌┌┬┐┬┌┬┐┌─┐┌┐┌┌┬┐┌─┐  ┌─┐┌─┐┌┬┐┌─┐┌─┐┌─┐┌─┐┬┌─┐┌─┐");
        System.out.println("├─┤ │ ├┤ │││ ││││││├┤ │││ │ │ │  ├─┘├┤  ││├─┤│ ┬│ ││ ┬││  │ │");
        System.out.println("┴ ┴ ┴ └─┘┘└┘─┴┘┴┴ ┴└─┘┘└┘ ┴ └─┘  ┴  └─┘─┴┘┴ ┴└─┘└─┘└─┘┴└─┘└─┘");
        System.out.println("-------------------------------------------------------------");

        System.out.println("Digite o CPF do Aluno que recebeu atendimento pedagogico: ");
        Long cpfAluno = Long.parseLong(scanner.nextLine());

        System.out.println("Digite o CPF do Pedagogo que realizou o atendimento pedagogico: ");
        Long cpfPedagogo = Long.parseLong(scanner.nextLine());

        for(Pessoa pessoa : PessoaRepository.getPessoas()) {
            if(pessoa instanceof Aluno) {
                if(pessoa.getCpf().equals(cpfAluno)) {
                    Aluno aluno = (Aluno)pessoa;
                    int id = pessoa.getId().intValue();
                    aluno.setAtendimentosSolicitados(aluno.getAtendimentosSolicitados() + 1);
                    PessoaRepository.pessoas.set(id, aluno);
                }
            } else if(pessoa instanceof Pedagogo) {
                if(pessoa.getCpf().equals(cpfPedagogo)) {
                    Pedagogo pedagogo = (Pedagogo)pessoa;
                    int id = pessoa.getId().intValue();
                    pedagogo.setAtendimentosRealizados(pedagogo.getAtendimentosRealizados() + 1);
                    PessoaRepository.pessoas.set(id, pedagogo);
                }
            }
        }
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
