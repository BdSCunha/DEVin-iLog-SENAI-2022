package org.devinhouse.superherois.cli;

import java.util.Scanner;

import org.devinhouse.superherois.exception.OpcaoInvalidaException;
import org.devinhouse.superherois.model.Heroi;
import org.devinhouse.superherois.model.Vilao;
import org.devinhouse.superherois.repository.PersonagemRepository;

// a) Crie no pacote 'org.devinhouse.superherois.cli' uma classe 'Display' para conter todos os métodos de interação com o usuário.
public class Display {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true)
            try {
                menu();
                String entrada = scanner.nextLine();
                int opcao = Integer.parseInt(entrada);
                
                // Para as opções 1 e 2, implemente um cadastramento de Herói e Vilão, respectivamente, solicitando os dados via console para o usuário e preenchendo os atributos dos respectivos objetos.
                if(opcao == 1) {
                    cadastrarSuperHeroi(scanner);
                } else if(opcao == 2) {
                    cadastrarVilao(scanner);
                } else if(opcao == 3) {
                    if(PersonagemRepository.getPersonagens().isEmpty()) System.out.println(ANSI_RED + "\nLista de personagens vazia." + ANSI_RESET);
                    else listarPersonagens();
                } else if(opcao == 4) {
                    // O sistema não deve ser encerrado até que o usuário selecione a opção 4, devendo ser exibido novamente o menu de opções após finalizar cada operação selecionada.
                    System.out.println("\nEncerrando aplicacao.\n");
                    scanner.close();
                    return;
                } else {
                    throw new OpcaoInvalidaException();
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED_BACKGROUND + "\nFormato INVALIDO: o valor digitado deve ser NUMERICO. Selecione uma opcao valida para continuar." + ANSI_RESET);
            } catch (OpcaoInvalidaException e) {
                System.out.println(ANSI_RED + "\nOpcao INVALIDA. Selecione uma opcao valida para continuar." + ANSI_RESET);
            } catch (Exception e) {
                System.out.printf(ANSI_RED + "Alguma excecao ocorreu: %s. Selecione uma opcao valida para continuar." + ANSI_RESET, e.getMessage());
            }
        }

    // b) Apresente no console do usuário um menu com as opções: 1 - Cadastrar Herói / 2 - Cadastrar Vilão / 3 - Listar / 4 - Sair
    public static void menu() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("╔═╗╦ ╦╔═╗╔═╗╦═╗ ╦ ╦╔═╗╦═╗╔═╗╦╔═╗");
        System.out.println("╚═╗║ ║╠═╝║╣ ╠╦╝═╠═╣║╣ ╠╦╝║ ║║╚═╗");
        System.out.println("╚═╝╚═╝╩  ╚═╝╩╚═ ╩ ╩╚═╝╩╚═╚═╝╩╚═╝");
        System.out.println("--------------------------------");
        System.out.println("1 - Cadastrar Heroi");
        System.out.println("2 - Cadastrar Vilao");
        System.out.println("3 - Listar");
        System.out.println("4 - Sair");
    }

    public static void cadastrarSuperHeroi(Scanner scanner) {
        System.out.println();
        System.out.println("┌─┐┌─┐┌┬┐┌─┐┌─┐┌┬┐┬─┐┌─┐┬─┐  ┌─┐┬ ┬┌─┐┌─┐┬─┐ ┬ ┬┌─┐┬─┐┌─┐┬");
        System.out.println("│  ├─┤ ││├─┤└─┐ │ ├┬┘├─┤├┬┘  └─┐│ │├─┘├┤ ├┬┘─├─┤├┤ ├┬┘│ ││");
        System.out.println("└─┘┴ ┴─┴┘┴ ┴└─┘ ┴ ┴└─┴ ┴┴└─  └─┘└─┘┴  └─┘┴└─ ┴ ┴└─┘┴└─└─┘┴");
        System.out.print("Digite o nome do super-heroi: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o superpoder do super-heroi: ");
        String superpoder = scanner.nextLine();

        System.out.print("Digite o nome humano verdadeiro do super-heroi: ");
        String nomeVidaReal = scanner.nextLine();

        Heroi heroi = new Heroi(nome, superpoder, nomeVidaReal);

        PersonagemRepository.adicionarPersonagem(heroi);

        System.out.printf(ANSI_GREEN + "%s cadastrado com sucesso!\n" + ANSI_RESET, heroi.toString());
    }

    public static void cadastrarVilao(Scanner scanner) {
        System.out.println();
        System.out.println("┌─┐┌─┐┌┬┐┌─┐┌─┐┌┬┐┬─┐┌─┐┬─┐  ┬  ┬┬┬  ┌─┐┌─┐");
        System.out.println("│  ├─┤ ││├─┤└─┐ │ ├┬┘├─┤├┬┘  └┐┌┘││  ├─┤│ │");
        System.out.println("└─┘┴ ┴─┴┘┴ ┴└─┘ ┴ ┴└─┴ ┴┴└─   └┘ ┴┴─┘┴ ┴└─┘");

        System.out.print("Digite o nome do vilao: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o superpoder do vilao: ");
        String superpoder = scanner.nextLine();

        System.out.print("Digite quanto tempo o vilao ficou preso: ");
        int tempoDePrisao = Integer.parseInt(scanner.nextLine());

        Vilao vilao = new Vilao(nome, superpoder, tempoDePrisao);

        PersonagemRepository.adicionarPersonagem(vilao);

        System.out.printf(ANSI_GREEN + "%s cadastrado com sucesso!\n" + ANSI_RESET, vilao.toString());
    }

    public static void listarPersonagens() {
        System.out.println();
        System.out.println("┬  ┬┌─┐┌┬┐┌─┐  ┌┬┐┌─┐  ┌─┐┌─┐┬─┐┌─┐┌─┐┌┐┌┌─┐┌─┐┌─┐┌┐┌┌─┐");
        System.out.println("│  │└─┐ │ ├─┤   ││├┤   ├─┘├┤ ├┬┘└─┐│ ││││├─┤│ ┬├┤ │││└─┐");
        System.out.println("┴─┘┴└─┘ ┴ ┴ ┴  ─┴┘└─┘  ┴  └─┘┴└─└─┘└─┘┘└┘┴ ┴└─┘└─┘┘└┘└─┘");

        PersonagemRepository.getPersonagens().forEach(System.out::println);
    }
}
