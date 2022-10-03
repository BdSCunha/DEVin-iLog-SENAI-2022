package br.org.sesisenai.estudante.exerciciosm01s03.exercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// e) Crie uma classe 'Principal' com método 'main'. Neste método, implemente a leitura do arquivo em anexo contendo o resultados de sorteios da mega-sena, e para cada linha, instancie um objeto de 'Concurso' e armazene eles em um ArrayList para manipulação posterior.
public class Principal {
    public static void main(String[] args) {
        try {
            File megasena = new File("src\\br\\org\\sesisenai\\estudante\\exerciciosm01s03\\megasena.txt");

            ArrayList<Concurso> ListaConcursos = retornaListaConcursos(megasena);

            // f) Imprima esta lista de concursos carregadas a partir do arquivo no console.
            for(Concurso concurso: ListaConcursos) System.out.println(concurso);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Concurso> retornaListaConcursos(File sorteiosMegaSena) throws FileNotFoundException {
        Scanner scanner = new Scanner(sorteiosMegaSena);

        ArrayList<Concurso> concursos = new ArrayList<Concurso>();

        while (scanner.hasNextLine()) {
            String[] sorteio = scanner.nextLine().split(",", 3);

            String[] dezenas = sorteio[2].split(",");
            int size = sorteio[2].split(",").length;
            int[] array = new int[size];
            for(int i = 0 ; i < size ; i++) array[i] = Integer.parseInt(dezenas[i]);

            Concurso concurso = new Concurso(Integer.valueOf(sorteio[0]), LocalDate.parse(sorteio[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")), array);
            concursos.add(concurso);
        }
        scanner.close();

        return concursos;
    }
}
