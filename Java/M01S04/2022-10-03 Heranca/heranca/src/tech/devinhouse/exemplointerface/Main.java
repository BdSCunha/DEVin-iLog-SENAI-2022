package tech.devinhouse.exemplointerface;

public class Main {
    public static void main(String[] args) {
        Trabalhador trabalhadorHomeOffice = new TrabalhadorHomeOffice();
        trabalhadorHomeOffice.baterPonto();

        Trabalhador trabalhadorPresencial = new TrabalhadorPresencial();
        trabalhadorPresencial.baterPonto();
    }
}
