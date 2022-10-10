package devinhouse.pratica.comparacoes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gato tom = new Gato("Tom", 6, LocalDate.now());
        Gato garfield = new Gato("Garfield", 2, LocalDate.now());
        Gato gatoDeBotas = new Gato("Gato de Botas", 8, LocalDate.now());
        Gato frajola = new Gato("Frajola", 1, LocalDate.now());
        Gato felix = new Gato("Felix", 19, LocalDate.now());
        Gato mingau = new Gato("Mingau", 12, LocalDate.now());

        List<Gato> gatos = new ArrayList<>();
        gatos.add(garfield);
        gatos.add(tom);
        gatos.add(gatoDeBotas);
        gatos.add(frajola);
        gatos.add(felix);
        gatos.add(mingau);
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println();

        Collections.sort(gatos, new ComparaIdade());
        System.out.println(gatos);
    }
}
