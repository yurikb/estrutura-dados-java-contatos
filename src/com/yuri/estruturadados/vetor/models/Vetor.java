package com.yuri.estruturadados.vetor.models;

public class Vetor {

    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

//    public void adiciona(String elemento) {
//        for (int i = 0; i < this.elementos.length; i++) {
//            if (this.elementos[i] == null) {
//                this.elementos[i] = elemento;
//                break;
//            }
//        }
//    }

    public boolean adiciona(String elemento) {
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, String elemento) {
        checaPosicaoValida(posicao);
        aumentaCapacidade();

        for (int i = tamanho - 1; i >= posicao; i--) {
            this.elementos[i+1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public boolean remove(int posicao) {
        checaPosicaoValida(posicao);
        for (int i = posicao; i < this.tamanho; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
        return true;
    }

    public String busca(int posicao) {
        checaPosicaoValida(posicao);
        return elementos[posicao];
    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            string.append(this.elementos[i]);
            string.append(", ");
        }

        if (this.tamanho > 0) {
            string.append(this.elementos[this.tamanho - 1]);
        }
        string.append("]");

        return string.toString();
    }

    private void checaPosicaoValida(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida! Informe um número de 0 a " + (this.tamanho - 1));
        }
    }
}
