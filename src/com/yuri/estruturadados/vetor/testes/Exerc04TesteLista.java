package com.yuri.estruturadados.vetor.testes;

import com.yuri.estruturadados.vetor.models.Contato;
import com.yuri.estruturadados.vetor.models.Lista;

public class Exerc04TesteLista {
    public static void main(String[] args) {

        Lista<String> lista = new Lista<>(3);
        lista.adiciona("A");
        lista.adiciona("B");
        lista.adiciona("C");
        lista.adiciona("C");
        System.out.println("Lista: " + lista);

        Lista<Contato> contratoLista = new Lista<>(3);
        contratoLista.adiciona(new Contato("Z", "X", "C"));
        contratoLista.adiciona(new Contato("A", "S", "D"));
        contratoLista.adiciona(new Contato("Q", "W", "E"));
        System.out.println("contratoLista: " + contratoLista);

        System.out.println(lista.contem("A"));
        System.out.println(lista.contem("B"));
        System.out.println(lista.contem("H"));

        System.out.println(contratoLista.contem(new Contato()));
        System.out.println(contratoLista.contem(new Contato("Q", "W", "E")));
        System.out.println(contratoLista.contem(contratoLista.busca(0)));

        System.out.println(contratoLista.ultimoIndice(contratoLista.busca(0)));
        System.out.println(lista.ultimoIndice("C"));
        lista.remove("C");
        System.out.println(lista);

        System.out.println(lista.obtem(0));
        System.out.println(lista.obtem(1));
        System.out.println(lista.obtem(2));

        lista.limpar();
        System.out.println(lista);

    }
}
