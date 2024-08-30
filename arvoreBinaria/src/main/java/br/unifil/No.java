package br.unifil;

public class No {
    private int conteudo;
    private No noEsq;
    private No noDir;

    public No(int conteudo) {
        this.conteudo = conteudo;
        this.noEsq = null;
        this.noDir = null;
    }

    public int getConteudo() {
        return conteudo;
    }

    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }

    public No getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(No noEsq) {
        this.noEsq = noEsq;
    }

    public No getNoDir() {
        return noDir;
    }

    public void setNoDir(No noDir) {
        this.noDir = noDir;
    }
}
