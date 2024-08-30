package org.fila;

public class Fila {
    private No refNoEntrada;

    public Fila() {
        this.refNoEntrada = null;
    }

    public void enfileirar(No novoNo) {
        novoNo.setRefNo(refNoEntrada);
        refNoEntrada = novoNo;
    }

    public boolean desenfileirar(Integer elemento) {
        if(estaVazia()) return false;

        No noAtual = refNoEntrada;
        No noAnterior = null;

        while(noAtual != null) {
            if(noAtual.getElemento().equals(elemento)) {
                if(noAnterior == null) {
                    refNoEntrada = noAtual.getRefNo();
                } else {
                    noAnterior.setRefNo(noAtual.getRefNo());
                }
                return true;
            }
            noAnterior = noAtual;
            noAtual = noAtual.getRefNo();
        }
        return false;
    }

    public boolean estaVazia() {
     return refNoEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntrada;

        if (refNoEntrada != null) {
            while (true) {
                stringRetorno += "[No {" + noAuxiliar.getElemento() + "}] --> ";
                if(noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }

    public boolean removerTodasOcorrencias(Integer elemento) {
        if(estaVazia()) return false;

        No noAtual = refNoEntrada;
        No noAnterior = null;
        boolean removed = false;

        while(noAtual != null) {
            if(noAtual.getElemento().equals(elemento)) {
                if(noAnterior == null) {
                    refNoEntrada = noAtual.getRefNo();
                } else {
                    noAnterior.setRefNo(noAtual.getRefNo());
                }
                removed = true;
            } else {
                noAnterior = noAtual;
            }
            noAtual = noAtual.getRefNo();
        }
        return removed;
    }

    public boolean buscar(Integer elemento) {
        No noAtual = refNoEntrada;
        while(noAtual != null) {
            if(noAtual.getElemento().equals(elemento)) {
                return true;
            }
            noAtual = noAtual.getRefNo();
        }
        return false;
    }

    public Integer maior() {
        if(estaVazia()) return null;

        Integer maior = refNoEntrada.getElemento();
        No noAtual = refNoEntrada.getRefNo();

        while(noAtual != null) {
            if(noAtual.getElemento() > maior) {
                maior = noAtual.getElemento();
            }
            noAtual = noAtual.getRefNo();
        }
        return maior;
    }

    public Integer menor() {
        if(estaVazia()) return null;

        Integer menor = refNoEntrada.getElemento();
        No noAtual = refNoEntrada.getRefNo();

        while(noAtual != null) {
            if(noAtual.getElemento() < menor) {
                menor = noAtual.getElemento();
            }
            noAtual = noAtual.getRefNo();
        }
        return menor;
    }

    public Double media() {
        if(estaVazia()) return null;

        int soma = 0;
        int quantidade = 0;
        No noAtual = refNoEntrada;

        while(noAtual != null) {
            soma += noAtual.getElemento();
            quantidade++;
            noAtual = noAtual.getRefNo();
        }
        return(double) soma / quantidade;
    }

    public int quantidade() {
        int quantidade = 0;
        No noAtual = refNoEntrada;

        while (noAtual != null) {
            quantidade++;
            noAtual = noAtual.getRefNo();
        }
        return quantidade;
    }
}
