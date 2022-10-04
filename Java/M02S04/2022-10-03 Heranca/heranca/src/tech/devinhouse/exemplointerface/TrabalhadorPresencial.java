package tech.devinhouse.exemplointerface;

public class TrabalhadorPresencial implements Trabalhador {

    @Override
    public void baterPonto() {
        System.out.println("Ponto batido PRESENCIALMENTE, via digital.");
    }    
}
