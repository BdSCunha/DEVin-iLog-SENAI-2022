import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        System.out.println(nomes.isEmpty());

        nomes.add("Bruno");
        nomes.add("Silva");
        nomes.add("Cunha");

        System.out.println(nomes);
        System.out.println("Tamanho da lista: " + nomes.size());

        boolean apagou = nomes.remove("Cunha"); // remove o primeiro elemento encontrado
        System.out.println("Elemento apagado? " + apagou);
        System.out.println(nomes);

        nomes.clear();
        System.out.println(nomes);

        System.out.println();

        /* **************************************************************************************************** */

        List<Long> numeros = Arrays.asList(10L, 34L, 56L, 78L);
        List<Long> copia = new ArrayList<>(numeros);

        System.out.println("numeros: " + numeros);
        System.out.println("copia: " + copia);
    }
}
