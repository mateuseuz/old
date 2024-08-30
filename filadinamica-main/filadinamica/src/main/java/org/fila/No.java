package org.fila;

public class No {
    private Integer elemento;
    private No refNo;

    public No(Integer elemento) {
        this.refNo = null;
        this.elemento = elemento;
    }

    public No() {
    }

    public Integer getElemento() {
        return elemento;
    }

    public void setElemento(Integer elemento) {
        this.elemento = elemento;
    }

    public No getRefNo() {
        return refNo;
    }

    public void setRefNo(No refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "elemento=" + elemento +
                '}';
    }
}
