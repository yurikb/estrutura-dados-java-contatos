package com.yuri.estruturadados.vetor.testes;

import com.yuri.estruturadados.vetor.models.Contato;
import com.yuri.estruturadados.vetor.models.VetorObjetos;

public class Exerc01Contato {
    public static void main(String[] args) {
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
