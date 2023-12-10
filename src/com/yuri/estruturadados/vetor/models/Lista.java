package com.yuri.estruturadados.vetor.models;

public class Lista<T> {

    private Object[] elementos;
    private int tamanho;

    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public boolean adiciona(T elemento) {
        aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public boolean adiciona(int posicao, T elemento) {
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
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = (T) this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void remove(int posicao) {
        checaPosicaoValida(posicao);
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }

    public void remove(T elemento) {
        int pos = this.busca(elemento);
        if (pos > -1) {
            this.remove(pos);
        }
    }

    public void limpar() {
        this.elementos = (T[]) new Object[this.elementos.length];
        this.tamanho = 0;
    }

    public T busca(int posicao) {
        checaPosicaoValida(posicao);
        return (T) elementos[posicao];
    }

    public int busca(T elemento) {
        for (int i = 0; i < this.tamanho - 1; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public T obtem(int posicao) {
        return this.busca(posicao);
    }

    public boolean contem(T elemento) {
        return busca(elemento) > -1;
    }

    public int ultimoIndice(T elemento) {
        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.elementos[i].equals(elemento)) {
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
