package devinhouse.pratica.comparacoes;

import java.util.Comparator;

public class ComparaIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato o1, Gato o2) {
        return o1.getIdade().compareTo(o2.getIdade());
    }
}
