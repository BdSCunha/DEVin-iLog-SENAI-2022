package br.org.sesisenai.estudante.exerciciosm01s03.exercicio9;

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

            // Implemente um código que pergunte ao usuário via linha de comando uma sequência de seis números.
            // Pesquise na lista de concursos (na lista carregada) se estes números já foram sorteados em algum concurso (números sorteados em qualquer ordem).
            // Caso tenha algum concurso com estes números sorteados, imprima-o no console, caso contrário imprima no console a frase:  'Números nunca sorteados'.

            System.out.print("Digite seis dezenas de 1 a 60, separadas por vírgulas (sem espaços e em qualquer ordem): ");
            Scanner scanner2 = new Scanner(System.in);
            String dezenasString = scanner2.next();
            scanner2.close();

            String[] splitArray = dezenasString.split(",");
            int[] dezenasArrayInt = new int[splitArray.length];
            for (int i = 0; i < splitArray.length; i++) dezenasArrayInt[i] = Integer.parseInt(splitArray[i]);

            ordenarDezenas(dezenasArrayInt);

            for(Concurso concurso: ListaConcursosDezenasOrdenadas) {
                if(Arrays.equals(concurso.getSorteados(), dezenasArrayInt)) {
                    System.out.println("Dezenas sorteadas no concurso " + concurso.toString());
                    return;
                }
            }
            System.out.println("Números nunca sorteados");
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