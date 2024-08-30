package org.example;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanho;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanho = 0;
    }

    public int size() {
        return this.tamanho;
    }

    public boolean isEmpty() {
        return this.tamanho == 0 ? true : false;
    }

    private No<T> getNo(int index) {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia!");

        if (index == 0) {
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < index; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    public T get(int index) {
        return this.getNo(index).getConteudo();
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);

        if(this.tamanho == 0) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProximoNo(cauda);
        } else {
            novoNo.setProximoNo(this.cauda);
            this.cabeca.setProximoNo(novoNo);
            this.cauda = novoNo;
        }

        this.tamanho++;
    }
    
    public void remove(int index) {
        if(index >= this.tamanho)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista.");

        No<T> noAuxiliar = this.cauda;

        if(index == 0) {
            this.cauda = this.cauda.getProximoNo();
            this.cabeca.setProximoNo(this.cauda);
        } else if(index == 1) {
            this.cauda.setProximoNo(this.cauda.getProximoNo().getProximoNo());
        } else {
            for(int i = 0; i < index-1; i++) {
                noAuxiliar = noAuxiliar.getProximoNo();
            }
            noAuxiliar.setProximoNo(noAuxiliar.getProximoNo().getProximoNo());
        }

        this.tamanho--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;

        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]-->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        strRetorno += isEmpty() ? "[]" : "[Reinicia]";

        return strRetorno;
    }
}
