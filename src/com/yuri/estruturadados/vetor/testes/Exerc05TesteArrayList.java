package com.yuri.estruturadados.vetor.testes;

import java.util.ArrayList;

public class Exerc05TesteArrayList {
    public static void main(String[] args) {

        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("A");
        stringArray.add("C");
        System.out.println(stringArray);

        stringArray.add(1, "B");
        System.out.println(stringArray);

        boolean existe = stringArray.contains("C");
        System.out.println(existe ? "Elemento C existe no array" : "Elemento C não existe no array");
        existe = stringArray.contains("Z");
        System.out.println(existe ? "Elemento Z existe no array" : "Elemento Z não existe no array");

        System.out.println(stringArray.indexOf("A"));
        System.out.println(stringArray.indexOf("B"));
        System.out.println(stringArray.get(1));
        System.out.println(stringArray.lastIndexOf("C"));
        System.out.println(stringArray.getFirst());
        System.out.println(stringArray.getLast());
        System.out.println(stringArray.hashCode());

        stringArray.clear();
        System.out.println(stringArray);
    }
}
