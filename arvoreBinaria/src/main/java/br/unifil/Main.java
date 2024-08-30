package br.unifil;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        // Testes com árvore vazia
        System.out.println("Testando remoção em árvore vazia:");
        arvoreBinaria.remover(5);

        // Inserindo elementos na árvore
        arvoreBinaria.inserir(10); // Raiz
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(1);
        arvoreBinaria.inserir(4);
        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(8);
        arvoreBinaria.inserir(11);
        arvoreBinaria.inserir(13);
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(20);

        // Exibindo árvore original
        System.out.println("\nÁrvore original:");
        exibirArvore(arvoreBinaria);

        // Removendo nós folha
        System.out.println("\nRemovendo nó 1 (folha):");
        arvoreBinaria.remover(1);
        exibirArvore(arvoreBinaria);

        System.out.println("\nRemovendo nó 8 (folha):");
        arvoreBinaria.remover(8);
        exibirArvore(arvoreBinaria);

        // Removendo nós com um filho
        System.out.println("\nRemovendo nó 4 (um filho):");
        arvoreBinaria.remover(4);
        exibirArvore(arvoreBinaria);

        System.out.println("\nRemovendo nó 6 (um filho):");
        arvoreBinaria.remover(6);
        exibirArvore(arvoreBinaria);

        // Removendo nós com dois filhos
        System.out.println("\nRemovendo nó 5 (dois filhos):");
        arvoreBinaria.remover(5);
        exibirArvore(arvoreBinaria);

        System.out.println("\nRemovendo nó 15 (dois filhos):");
        arvoreBinaria.remover(15);
        exibirArvore(arvoreBinaria);

        // Removendo a raiz
        System.out.println("\nRemovendo a raiz 10:");
        arvoreBinaria.remover(10);
        exibirArvore(arvoreBinaria);

        // Removendo valores inexistentes
        System.out.println("\nTentando remover nó inexistente 40:");
        arvoreBinaria.remover(40);
        exibirArvore(arvoreBinaria);

        // Removendo todos os nós até a árvore estar vazia
        arvoreBinaria.remover(3);
        arvoreBinaria.remover(7);
        arvoreBinaria.remover(12);
        arvoreBinaria.remover(13);
        arvoreBinaria.remover(11);
        arvoreBinaria.remover(18);
        arvoreBinaria.remover(17);
        arvoreBinaria.remover(20);

        System.out.println("\nÁrvore após todas as remoções:");
        exibirArvore(arvoreBinaria);
    }

    public static void exibirArvore(ArvoreBinaria arvore) {
        if(arvore.getRaiz() == null) {
            System.out.println("A árvore está vazia!");
        } else {
            System.out.println("\nPré-ordem: ");
            arvore.preOrdem(arvore.getRaiz());
            System.out.println("\nEm ordem: ");
            arvore.emOrdem(arvore.getRaiz());
            System.out.println("\nPós ordem: ");
            arvore.posOrdem(arvore.getRaiz());
        }
    }
}
