package br.org.sesisenai.estudante.exerciciosm01s03.exercicio10;

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

            // Implemente um código (baseado na lista de concursos carregados do arquivo) que identifique o número mais frequentemente sorteado e o menos frequentemente sorteado.
            // Imprima no console ambos os números indicando a quantidade de ocorrências/sorteios de cada um.
            HashMap<String, Integer> hashMapFrequenciaDezenasSorteadas = obterHashMapFrequenciaDezenasSorteadas(ListaConcursosDezenasOrdenadas);

            int maxValueInHashMap = (Collections.max(hashMapFrequenciaDezenasSorteadas.values()));
            int minValueInHashMap = (Collections.min(hashMapFrequenciaDezenasSorteadas.values()));

            for (Entry<String, Integer> set: hashMapFrequenciaDezenasSorteadas.entrySet()) {
                if(set.getValue() == minValueInHashMap) System.out.println("Dezena menos sorteada: " + set.getKey() + " / " + set.getValue() + " vezes");
                if(set.getValue() == maxValueInHashMap) System.out.println("Dezena mais sorteada: " + set.getKey() + " / " + set.getValue() + " vezes");
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

    public static HashMap<String, Integer> obterHashMapFrequenciaDezenasSorteadas(ArrayList<Concurso> ListaConcursosDezenasOrdenadas) {
        ArrayList<Integer> dezenasSorteadas = new ArrayList<Integer>();
        for(Concurso concurso: ListaConcursosDezenasOrdenadas) {
            for(int number: concurso.getSorteados()) {
                dezenasSorteadas.add(number);
            }
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 1 ; i < 61 ; i++) {
            int occurrences = Collections.frequency(dezenasSorteadas, i);
            map.put(String.valueOf(i), occurrences);
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