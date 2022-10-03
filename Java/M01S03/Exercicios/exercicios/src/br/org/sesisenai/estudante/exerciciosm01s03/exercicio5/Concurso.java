package br.org.sesisenai.estudante.exerciciosm01s03.exercicio5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

// Vamos criar uma funcionalidade de manipulação dos resultados de sorteios da mega-sena dividido em várias partes/exercícios.
// A mega-sena trata-se de um sorteio de seis números de 1 a 60, e o grande ganhador é quem acertar estes seis números sorteados.
// * DICAS: 
// - Como é um arquivo csv, usar o método split() para separar os itens, e depois instanciar um objeto concurso para cada linha do arquivo, carregando os atributos com os valores.
// - Para imprimir os itens de um array, pode-se usar o método utilitário 'Arrays.toString()'.

// a) Primeiro crie uma classe 'Concurso' para representar um concurso/sorteio.
public class Concurso {
    // b) Nesta classe, crie os atributos privados abaixo e os respectivos métodos getters & setters:
    private Integer numero;
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    private LocalDate data;
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    private int[] sorteados;
    public int[] getSorteados() {
        return sorteados;
    }
    public void setSorteados(int[] sorteados) {
        this.sorteados = sorteados;
    }

    // c) Implemente também o método 'toString()' nesta classe.
    @Override
    public String toString() {
        return this.getNumero() + " " + this.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + Arrays.toString(this.getSorteados());
    }

    // d) Adicione o construtor padrão/default, e um construtor que receba parâmetros para inicializar cada atributo desta classe.
    public Concurso(String sorteio) {
    }
    
    public Concurso(Integer numero, LocalDate data, int[] sorteados) {
        this.numero = numero;
        this.data = data;
        this.sorteados = sorteados;
    }
}
