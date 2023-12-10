package com.yuri.estruturadados.vetor.testes;

import com.yuri.estruturadados.vetor.models.Vetor;

public class Exerc02Vetor {
    public static void main(String[] args) {

        Vetor vetor = new Vetor(5);
        vetor.adiciona("A");
        vetor.adiciona("B");
        vetor.adiciona("C");
        vetor.adiciona("D");
        vetor.adiciona("E");
        vetor.adiciona("F");
        System.out.println("Vetor: " + vetor.toString());
        System.out.println("Busca posição 0: " + vetor.busca(0));

        vetor.adiciona(0, "X");
        vetor.adiciona(3, "Z");
        System.out.println("Vetor: " + vetor.toString());

        vetor.remove(0);
        System.out.println("Vetor: " + vetor.toString());

        int position = vetor.busca("Z");
        if (position > -1) {
            vetor.remove(position);
            System.out.println("Elemento Z removido");
        } else {
            System.out.println("Elemento não encontrado");
        }

        System.out.println("Busca elemento posição 0: " + vetor.busca(0));
        System.out.println("Posição do A: " + vetor.busca("A"));
        System.out.println("Tamanho do vetor: " + vetor.tamanho());
        System.out.println("Vetor: " + vetor.toString());
        System.out.println("----------*------------*-----------");
    }
}
