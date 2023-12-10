package com.yuri.estruturadados.vetor.testes;

import com.yuri.estruturadados.vetor.models.Contato;
import com.yuri.estruturadados.vetor.models.VetorObjetos;

public class Exerc03VetorObjetos {
    public static void main(String[] args) {

        VetorObjetos vetorObjetos = new VetorObjetos(5);
        vetorObjetos.adiciona(new Object());
        vetorObjetos.adiciona(new Object());
        vetorObjetos.adiciona(new Object());
        int objetoTamanho = vetorObjetos.tamanho();
        System.out.println("vetorObjectos: " + vetorObjetos);
        System.out.println("objetoTamanho: " + objetoTamanho);
        vetorObjetos.adiciona(0, "Objeto?");
        vetorObjetos.adiciona("Objeto 2");
        vetorObjetos.adiciona("Objeto 3");
        System.out.println("vetorObjectos: " + vetorObjetos);
        System.out.println("vetorObjectos busca 0: " + vetorObjetos.busca(0));
        System.out.println("vetorObjectos remove 0: " + vetorObjetos.remove(0));
        System.out.println("vetorObjectos: " + vetorObjetos);
        System.out.println("----------*------------*-----------");

        // Teste Contato
        System.out.println("\n");
        VetorObjetos vo1 = new VetorObjetos(3);
        Contato contato = new Contato();
        contato.setNome("Yuri");
        contato.setEmail("yuri@teste.com");
        contato.setTelefone("(99) 123456789");
        System.out.println("Contrato object: " + contato);
        System.out.println("Contrato nome: " + contato.getNome());
        System.out.println("Contrato telefone: " + contato.getTelefone());
        System.out.println("Contrato email: " + contato.getEmail());
        System.out.println("\n");

        Contato contato2 = new Contato("Bean", "(00) 908787651", "email@email.com");
        System.out.println("Contrato2 object: " + contato2);
        System.out.println("Contrato2 nome: " + contato2.getNome());
        System.out.println("Contrato2 telefone: " + contato2.getTelefone());
        System.out.println("Contrato2 email: " + contato2.getEmail());

        vo1.adiciona(contato);
        vo1.adiciona(contato2);
        System.out.println("VetorObjetos1: " + vo1);

    }
}
