package br.org.sesisenai.estudante.exerciciosm01s03.exercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            File megasena = new File("src\\br\\org\\sesisenai\\estudante\\exerciciosm01s03\\megasena.txt");

            ArrayList<Concurso> ListaConcursosDezenasOrdenadas = retornaListaConcursosDezenasOrdenadas(megasena);

            // Implemente um código agora para imprimir a lista de concursos da lista carregada, ordenando agora, os itens pelo atributo de número do concurso.
            // A ordenação deve ser em ordem crescente de número do concurso, onde o concurso de menor número deve vir primeiro.
            Collections.sort(ListaConcursosDezenasOrdenadas, new OrdernarPorNumeroDoSorteio());

            for(Concurso concurso: ListaConcursosDezenasOrdenadas) System.out.println(concurso);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Concurso> retornaListaConcursosDezenasOrdenadas(File sorteiosMegaSena) throws FileNotFoundException {
        Scanner scanner = new Scanner(sorteiosMegaSena);

        ArrayList<Concurso> concursos = new ArrayList<Concurso>();

        while (scanner.hasNextLine()) {
            String[] sorteio = scanner.nextLine().split(",", 3);

            String[] dezenas = sorteio[2].split(",");
            int size = sorteio[2].split(",").length;
            int[] array = new int[size];
            for(int i = 0 ; i < size ; i++) array[i] = Integer.parseInt(dezenas[i]);

            ordenarDezenas(array);

            Concurso concurso = new Concurso(Integer.valueOf(sorteio[0]), LocalDate.parse(sorteio[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")), array);
            concursos.add(concurso);
        }
        scanner.close();

        return concursos;
    }

    public static void ordenarDezenas(int[] array) {
        Arrays.sort(array);
    }
}

class OrdernarPorNumeroDoSorteio implements Comparator<Concurso>
{
    public int compare(Concurso o1, Concurso o2) {
        return o1.getNumero() - o2.getNumero();
    }
}