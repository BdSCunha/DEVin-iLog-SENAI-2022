package tech.devinhouse.exemplointerface;

public class TrabalhadorHomeOffice implements Trabalhador {

    @Override
    public void baterPonto() {
        System.out.println("Ponto batido REMOTAMENTE, via aplicativo.");
    }
}
