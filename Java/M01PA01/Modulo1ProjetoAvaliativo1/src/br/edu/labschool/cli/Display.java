package br.edu.labschool.cli;

import br.edu.labschool.Main;

public class Display {
    public static void menuPrincipal() {
        System.out.println();
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                                                          ║");
        System.out.println("║    ╔═╗╦╔═╗╔╦╗╔═╗╔╦╗╔═╗  ╦  ╔═╗╔╗   ╔═╗╔═╗╦ ╦╔═╗╔═╗╦      ║");
        System.out.println("║    ╚═╗║╚═╗ ║ ║╣ ║║║╠═╣  ║  ╠═╣╠╩╗  ╚═╗║  ╠═╣║ ║║ ║║      ║");
        System.out.println("║    ╚═╝╩╚═╝ ╩ ╚═╝╩ ╩╩ ╩  ╩═╝╩ ╩╚═╝  ╚═╝╚═╝╩ ╩╚═╝╚═╝╩═╝    ║");
        System.out.println("║                                                          ║");
        System.out.println("╠══════════════════════ " + Main.ANSI_YELLOW + "CADASTRAMENTO" + Main.ANSI_RESET + " ═════════════════════╣");
        System.out.println("╠═ " + Main.ANSI_YELLOW + "1" + Main.ANSI_RESET + " - Cadastrar Aluno                                     ║");
        System.out.println("╠═ " + Main.ANSI_YELLOW + "2" + Main.ANSI_RESET + " - Cadastrar Professor                                 ║");
        System.out.println("╠═ " + Main.ANSI_YELLOW + "3" + Main.ANSI_RESET + " - Cadastrar Pedagogo                                  ║");
        System.out.println("║                                                          ║");
        System.out.println("╠════════════════════════ " + Main.ANSI_CYAN + "SERVICOS" + Main.ANSI_RESET + " ════════════════════════╣");
        System.out.println("╠═ " + Main.ANSI_CYAN + "4" + Main.ANSI_RESET + " - Atualizar status matricula aluno                    ║");
        System.out.println("╠═ " + Main.ANSI_CYAN + "5" + Main.ANSI_RESET + " - Realizar atendimento pedagógico                     ║");
        System.out.println("║                                                          ║");
        System.out.println("╠═══════════════════════ " + Main.ANSI_MAGENTA + "RELATORIOS" + Main.ANSI_RESET + " ═══════════════════════╣");
        System.out.println("╠═ " + Main.ANSI_MAGENTA + "6" + Main.ANSI_RESET + " - Listar Pessoas (Alunos, Professores e/ou Pedagogos) ║");
        System.out.println("╠═ " + Main.ANSI_MAGENTA + "7" + Main.ANSI_RESET + " - Relatorio de Alunos                                 ║");
        System.out.println("╠═ " + Main.ANSI_MAGENTA + "8" + Main.ANSI_RESET + " - Relatorio de Professores                            ║");
        System.out.println("╠═ " + Main.ANSI_MAGENTA + "9" + Main.ANSI_RESET + " - Relatorio de atendimento pedagogico dos Alunos      ║");
        System.out.println("╠═ " + Main.ANSI_MAGENTA + "10" + Main.ANSI_RESET + " - Relatorio de atendimento pedagogico dos Pedagogos  ║");
        System.out.println("║                                                          ║");
        System.out.println("╠═ " + Main.ANSI_RED + "11" + Main.ANSI_RESET + " - Sair / Encerrar aplicacao ═════════════════════════╣");
        System.out.println("║                                                          ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println();
        System.out.print("Selecione o numero de uma das opcoes acima para continuar: ");
    }
}
