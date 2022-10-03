package arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ArquivosNIO {
    public static void main(String[] args) throws IOException {
        // C:\Users\cub1jvl\Documents\DEVin-iLog-SENAI-2022\Java\M01S03\2022-09-28 Handling Files
        Path path = Paths.get("arquivo.txt");

        if(Files.notExists(path)) {
            Files.createFile(path);
        } else {
            System.out.println("Arquivo ja existe!");
        }

        // Escrevendo em arquivos
        Path pathStarWars = Paths.get("StarWars.txt");
        if(Files.notExists(pathStarWars)) Files.createFile(pathStarWars);
        final List<String> nomesStarWars = List.of("Luke Skywalker", "Obi-Wan Kenobi", "Han Solo", "Darth Vader");
        for(String nome: nomesStarWars) {
            nome = nome + "\n";
            // Files.writeString(path, nome, StandardOpenOption.APPEND);
            Files.write(pathStarWars, nome.getBytes(), StandardOpenOption.APPEND);
        }

        Path pathStarTrek = Paths.get("StarTrek.txt");
        if(Files.notExists(pathStarTrek)) Files.createFile(pathStarTrek);
        final List<String> nomesStarTrek = List.of("James Kirk", "Spock", "Nyota Uhura", "Leonard McCoy", "Montgomery Scott");
        for(String nome: nomesStarTrek) {
            nome = nome + "\n";
            // Files.writeString(path, nome, StandardOpenOption.APPEND);
            Files.write(pathStarTrek, nome.getBytes(), StandardOpenOption.APPEND);
        }

        // Lendo arquivos
        List<String> nomesLidosSW = Files.readAllLines(pathStarWars);
        System.out.println(nomesLidosSW);

        List<String> nomesLidosST = Files.readAllLines(pathStarTrek);
        System.out.println(nomesLidosST);
    }
}
