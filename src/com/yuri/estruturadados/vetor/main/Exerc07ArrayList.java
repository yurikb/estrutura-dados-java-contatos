package com.yuri.estruturadados.vetor.main;

import com.yuri.estruturadados.vetor.models.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class Exerc07ArrayList extends Exerc06Lista {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Contato> lista = new ArrayList<>(30);

        criarContatosDinamicamente(30, lista);

        int opcao = 1;
        while (opcao != 0) {
            opcao = obterOpcaoMenu(scan);

            switch (opcao) {
                case 1:
                    adicionarContatoFinal(scan, lista);
                    break;
                case 2:
                    adicionarContatoPosicao(scan, lista);
                    break;
                case 3:
                    obtemContatoPosicao(scan, lista);
                    break;
                case 4:
                    obtemContato(scan, lista);
                    break;
                case 5:
                    pesquisarUltimoIndice(scan, lista);
                    break;
                case 6:
                    verificarContatoExiste(scan, lista);
                    break;
                case 7:
                    excluirPorPosicao(scan, lista);
                    break;
                case 8:
                    excluirContato(scan, lista);
                    break;
                case 9:
                    verificarTamanhoDoVetor(lista);
                    break;
                case 10:
                    limparVetor(lista);
                    break;
                case 11:
                    imprimeArrayList(lista);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Programa finalizado. Obrigado por utilizar a Aperture Science.");
    }

    private static void obtemContatoPosicao(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.get(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void verificarTamanhoDoVetor(ArrayList<Contato> lista) {
        System.out.println("Tamanho do vetor: " + lista.size());
    }

    private static void limparVetor(ArrayList<Contato> lista) {
        lista.clear();
        System.out.println("Todos contatos excluídos com sucesso!");
    }

    private static void imprimeArrayList(ArrayList<Contato> lista) {
        System.out.println("ArrayList de contatos completa:");
        System.out.println(lista);
    }

    private static void excluirPorPosicao(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

        try {
            lista.remove(pos);
            System.out.println("Contato na posição " + pos + " excluído com sucesso!");
            Contato contato = lista.get(pos);
            System.out.println(contato);
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void excluirContato(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

        try {
            Contato contato = lista.get(pos);
            lista.remove(contato);
            System.out.println("Contato excluído com sucesso!");
            System.out.println(contato);
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
        System.out.println("\n");
    }

    private static void obtemContato(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.get(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);
            pos = lista.indexOf(contato);
            System.out.println("Contato encontrado na posição: " + pos);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void pesquisarUltimoIndice(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.get(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);

            System.out.println("Fazendo pesquisa do último índice do contato encontrado:");
            pos = lista.lastIndexOf(contato);
            System.out.println("Contato encontrado na posição: " + pos);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void verificarContatoExiste(Scanner scan, ArrayList<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.get(pos);
            boolean existe = lista.contains(contato);
            if (existe) {
                System.out.println("Contato existe. Seguem dados:");
                System.out.println(contato);
            } else {
                System.out.println("Contato não existe.");
            }
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void adicionarContatoFinal(Scanner scan, ArrayList<Contato> lista) {
        System.out.println("Criando um contato, entre as informações:");

        String nome = leInformacao("Entre com o nome: ", scan);
        String telefone = leInformacao("Entre com o telefone: ", scan);
        String email = leInformacao("Entre com o email: ", scan);

        Contato contato = new Contato(nome, telefone, email);
        lista.add(contato);
        System.out.println("Contato adicionado com sucesso!");
        System.out.println(contato);
        System.out.println("\n");

    }

    private static void adicionarContatoPosicao(Scanner scan, ArrayList<Contato> lista) {
        System.out.println("Criando um contato, entre as informações:");

        String nome = leInformacao("Entre com o nome: ", scan);
        String telefone = leInformacao("Entre com o telefone: ", scan);
        String email = leInformacao("Entre com o email: ", scan);

        Contato contato = new Contato(nome, telefone, email);

        int posicao = leInformacaoInt("Entre com a posição:", scan);
        if (posicao >= 0 && posicao <= lista.size()) {
            try {
                lista.add(posicao, contato);
                System.out.println("Contato adicionado com sucesso!");
                System.out.println(contato);
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Posição inválida. Contato não adicionado.\n");
            }
        }


    }

    public static void criarContatosDinamicamente(int quantidade, ArrayList<Contato> lista) {
        Contato contato;
        for (int i = 1; i <= quantidade; i++) {
            contato = new Contato();
            contato.setNome("Contato " + i);
            contato.setEmail("contato" +i+ "@email.com");
            contato.setTelefone(i+ "11111111" +i);
            lista.add(contato);
        }
    }
}
