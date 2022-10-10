package org.devinhouse.superherois.repository;

import java.util.ArrayList;
import java.util.List;

import org.devinhouse.superherois.model.Personagem;

// Crie uma classe de repositório de dados chamada "PersonagemRepository" no pacote 'org.devinhouse.superherois.repository'.
public class PersonagemRepository {
    // Nesta classe, crie um atributo privado do tipo lista (List/ArrayList) para armazenar os personagens cadastrados, fornecendo métodos públicos para inserir e consultar os personagens.
    private static List<Personagem> personagens = new ArrayList<>();

    public static List<Personagem> getPersonagens() {
        return personagens;
    }

    public static void adicionarPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }
}
