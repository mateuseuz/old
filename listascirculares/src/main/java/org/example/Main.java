package org.example;

public class Main {
    public static void main(String[] args)  {
        ListaCircular<Integer> listaCircular = new ListaCircular<>();
        System.out.println(listaCircular);

        listaCircular.add(2);
        listaCircular.add(4);
        listaCircular.add(3);
        listaCircular.add(3);
        listaCircular.add(10);
        listaCircular.add(0);
        System.out.println(listaCircular);
        
        listaCircular.remove(0);
        System.out.println(listaCircular);

        System.out.println(listaCircular.get(6));
    }
}
