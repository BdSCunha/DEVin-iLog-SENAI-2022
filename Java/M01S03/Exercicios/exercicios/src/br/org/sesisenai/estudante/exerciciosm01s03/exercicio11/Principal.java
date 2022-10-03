package br.org.sesisenai.estudante.exerciciosm01s03.exercicio11;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try {
            File megasena = new File("src\\br\\org\\sesisenai\\estudante\\exerciciosm01s03\\megasena.txt");

            ArrayList<Concurso> ListaConcursosDezenasOrdenadas = retornaListaConcursosDezenasOrdenadas(megasena);

            Collections.sort(ListaConcursosDezenasOrdenadas, new OrdernarPorNumeroDoSorteio());

            // Implemente um código que identifique o número mais "atrasado", ou seja, o número que está a mais tempo sem ser sorteado de acordo com a lista de concursos carregadas do arquivo.
            // Imprima este número no console juntamente com a data do último concurso em que ele foi sorteado.
            HashMap<String, LocalDate> hashMapDataDezenasSorteadas = obterHashMapDataDezenasSorteadas(ListaConcursosDezenasOrdenadas);

            LocalDate minDate = Collections.min(hashMapDataDezenasSorteadas.values());

            for (Entry<String, LocalDate> set: hashMapDataDezenasSorteadas.entrySet()) {
                if(set.getValue() == minDate) System.out.println("Dezena mais atrasada: " + set.getKey() + " / Sorteada pela ultima vez em " + set.getValue());
            }
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

    public static HashMap<String, LocalDate> obterHashMapDataDezenasSorteadas(ArrayList<Concurso> ListaConcursosDezenasOrdenadas) {
        HashMap<String, LocalDate> map = new HashMap<String, LocalDate>();
        for(int i = 1 ; i < 61 ; i++) {
            for(Concurso concurso: ListaConcursosDezenasOrdenadas) {
                Integer[] newArray = new Integer[concurso.getSorteados().length];
                int j = 0;
                for (int dezena : concurso.getSorteados()) newArray[j++] = Integer.valueOf(dezena);

                if(Arrays.asList(newArray).contains(i)) map.put(String.valueOf(i), concurso.getData());
            }
        }
        return map;
    }
}

class OrdernarPorNumeroDoSorteio implements Comparator<Concurso>
{
    public int compare(Concurso o1, Concurso o2) {
        return o1.getNumero() - o2.getNumero();
    }
}