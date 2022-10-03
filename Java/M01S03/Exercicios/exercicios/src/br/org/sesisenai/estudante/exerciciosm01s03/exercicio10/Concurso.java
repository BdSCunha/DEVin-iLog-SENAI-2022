package br.org.sesisenai.estudante.exerciciosm01s03.exercicio10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Concurso {
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

    @Override
    public String toString() {
        return this.getNumero() + " " + this.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + Arrays.toString(this.getSorteados());
    }

    public Concurso() {
    }

    public Concurso(String sorteio) {
    }
    
    public Concurso(Integer numero, LocalDate data, int[] sorteados) {
        this.numero = numero;
        this.data = data;
        this.sorteados = sorteados;
    }
}
