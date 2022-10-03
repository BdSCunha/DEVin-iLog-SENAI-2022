package br.org.sesisenai.estudante.exerciciosm01s03.exercicio8;

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

            Collections.sort(ListaConcursosDezenasOrdenadas, new OrdernarPorNumeroDoSorteio());

            // Implemente um código que pergunte ao usuário via linha de comando uma data (no formato igual ao previsto no arquivo).
            // Pesquise na lista de concursos (na lista carregada) se naquela data teve sorteio da mega-sena, e em caso positivo imprima no console os números sorteados neste sorteio.
            // Em caso negativo, imprima a frase "Não houve sorteio neste dia".
            System.out.print("Digite a data de um sorteio (formato AAAA-MM-DD): ");
            Scanner scanner2 = new Scanner(System.in);
            String data = scanner2.next();
            scanner2.close();

            for(Concurso concurso: ListaConcursosDezenasOrdenadas) {
                if(LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(LocalDate.parse(concurso.getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))) {
                    System.out.println(concurso);
                    return;
                }
            }
            System.out.println("Nao houve sorteio neste dia");
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