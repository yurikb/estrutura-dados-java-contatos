package com.yuri.estruturadados.vetor.main;

import com.yuri.estruturadados.vetor.models.Contato;
import com.yuri.estruturadados.vetor.models.Lista;

import java.util.Scanner;

public class Exerc06Lista {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lista<Contato> lista = new Lista<>(30);

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
                    imprimeLista(lista);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Usuario digitou 0. Programa finalizado. Obrigado por utilizar a Aperture Science.");
    }

    private static void obtemContatoPosicao(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.busca(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void verificarTamanhoDoVetor(Lista<Contato> lista) {
        System.out.println("Tamanho do vetor: " + lista.tamanho());
    }

    private static void limparVetor(Lista<Contato> lista) {
        lista.limpar();
        System.out.println("Todos contatos excluídos com sucesso!");
    }

    private static void imprimeLista(Lista<Contato> lista) {
        System.out.println("Lista de contatos completa:");
        System.out.println(lista);
    }

    private static void excluirPorPosicao(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

        try {
            lista.remove(pos);
            System.out.println("Contato na posição " + pos + " excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void excluirContato(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

        try {
            Contato contato = lista.busca(pos);
            lista.remove(contato);
            System.out.println("Contato excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
        System.out.println("\n");
    }

    private static void obtemContato(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.busca(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);

            System.out.println("Fazendo pesquisa do contato encontrado:");
            pos = lista.busca(contato);
            System.out.println("Contato encontrado na posição: " + pos);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void pesquisarUltimoIndice(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.busca(pos);
            System.out.println("Contato existe. Seguem dados:");
            System.out.println(contato);

            System.out.println("Fazendo pesquisa do último índice do contato encontrado:");
            pos = lista.ultimoIndice(contato);
            System.out.println("Contato encontrado na posição: " + pos);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    private static void verificarContatoExiste(Scanner scan, Lista<Contato> lista) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

        try {
            Contato contato = lista.busca(pos);
            boolean existe = lista.contem(contato);
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

    private static void adicionarContatoFinal(Scanner scan, Lista<Contato> lista) {
        System.out.println("Criando um contato, entre as informações:");

        String nome = leInformacao("Entre com o nome: ", scan);
        String telefone = leInformacao("Entre com o telefone: ", scan);
        String email = leInformacao("Entre com o email: ", scan);

        Contato contato = new Contato(nome, telefone, email);
        lista.adiciona(contato);
        System.out.println("Contato adicionado com sucesso!");
        System.out.println(contato);
        System.out.println("\n");

    }

    private static void adicionarContatoPosicao(Scanner scan, Lista<Contato> lista) {
        System.out.println("Criando um contato, entre as informações:");

        String nome = leInformacao("Entre com o nome: ", scan);
        String telefone = leInformacao("Entre com o telefone: ", scan);
        String email = leInformacao("Entre com o email: ", scan);

        Contato contato = new Contato(nome, telefone, email);

        int posicao = leInformacaoInt("Entre com a posição:", scan);
        if (posicao >= 0 && posicao <= lista.tamanho()) {
            try {
                lista.adiciona(posicao, contato);
                System.out.println("Contato adicionado com sucesso!");
                System.out.println(contato);
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Posição inválida. Contato não adicionado.\n");
            }
        }


    }

    public static String leInformacao(String msg, Scanner scan) {
        System.out.println(msg);
        return scan.nextLine();
    }

    public static int leInformacaoInt(String msg, Scanner scan) {
        boolean entradaValida = false;
        int num = 0;

        while (!entradaValida) {
            try {
                System.out.println(msg);
                String entrada = scan.nextLine();
                num = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida, forneça um número. Digite novamente");
            }
        }

        return num;
    }

    public static int obterOpcaoMenu(Scanner scan) {
        boolean entradaValida = false;
        String entrada;
        int opcao = 0;

        while (!entradaValida) {
            System.out.println("Escolha a opção");
            System.out.println("1 - Adiciona contato no final da lista");
            System.out.println("2 - Adiciona contato em uma posição específica da lista");
            System.out.println("3 - Obtém contato de uma posição específica");
            System.out.println("4 - Consulta contato");
            System.out.println("5 - Consulta último índice do contato");
            System.out.println("6 - Verifica se contato existe");
            System.out.println("7 - Excluir contato por posição");
            System.out.println("8 - Excluir contato");
            System.out.println("9 - Verifica tamanho da lista");
            System.out.println("10 - Excluir todos contatos da lista");
            System.out.println("11 - Imprime lista");
            System.out.println("0 - Sair");

            try {
                entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 11) {
                    entradaValida = true;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Insira o número da opção.\n\n");
            }
        }

        return opcao;
    }

    public static void criarContatosDinamicamente(int quantidade, Lista<Contato> lista) {
        Contato contato;
        for (int i = 1; i <= quantidade; i++) {
            contato = new Contato();
            contato.setNome("Contato " + i);
            contato.setEmail("contato" +i+ "@email.com");
            contato.setTelefone(i+ "11111111" +i);
            lista.adiciona(contato);
        }
    }
}
