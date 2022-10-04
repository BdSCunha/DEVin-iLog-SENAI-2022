package tech.devinhouse.heranca.animal;

public class Main {
    public static void main(String[] args) {
        Zebra zebra = new Zebra();
        zebra.nome = "Marvin";      // Herdado da classe Animal
        zebra.numeroDeListras = 50; // Herdado da classe Zebra
        System.out.println(zebra.emitirSom());

        Gato gato = new Gato();
        gato.nome = "Tom";          // Herdado da classe Animal
        gato.corDoPelo = "Cinza";   // Herdado da classe Felino
        System.out.println(gato.emitirSom());
    }
}
