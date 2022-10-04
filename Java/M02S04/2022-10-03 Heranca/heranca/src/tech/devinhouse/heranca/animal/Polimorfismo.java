package tech.devinhouse.heranca.animal;

public class Polimorfismo {
    public static void main(String[] args) {
        Animal gato = new Gato();
        System.out.println(gato.emitirSom());

        Animal tigre = new Tigre();
        System.out.println(tigre.emitirSom());
    }
}
