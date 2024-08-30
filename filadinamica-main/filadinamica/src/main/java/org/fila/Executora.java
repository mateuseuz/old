package org.fila;

import java.util.Scanner;

public class Executora {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Fila filaDinamica = new Fila();
       int opcao;
       Integer elemento;

       do {
          System.out.println("==============================");
          System.out.println("Selecione uma opção\n");
          System.out.println("[1] Enfileirar elemento");
          System.out.println("[2] Desenfileirar elemento");
          System.out.println("[3] Remover ocorrências");
          System.out.println("[4] Listar elementos");
          System.out.println("[5] Buscar elemento");
          System.out.println("[6] Maior elemento");
          System.out.println("[7] Menor elemento");
          System.out.println("[8] Obter média");
          System.out.println("[9] Ver quantidade\n");
          System.out.println("[0] SAIR");
          System.out.println("==============================");
          opcao = scanner.nextInt();

          switch(opcao) {
             case 1:
                System.out.print("Insira o elemento a ser adicionado: ");
                elemento = scanner.nextInt();
                filaDinamica.enfileirar(new No(elemento));
                System.out.println("Elemento adicionado: " + elemento);
                break;

             case 2:
                System.out.print("Insira o elemento a ser removido: ");
                elemento = scanner.nextInt();
                boolean removido = filaDinamica.desenfileirar(elemento);
                System.out.println(removido ? "Elemento removido: " + elemento : "Elemento não encontrado na fila.");
                break;

             case 3:
                System.out.print("Insira o elemento a ser removido: ");
                elemento = scanner.nextInt();
                System.out.println(filaDinamica.removerTodasOcorrencias(elemento) ? "Todas as ocorrências do elemento " + elemento + " foram removidas." : "Elemento não encontrado na fila.");
                break;

             case 4:
                System.out.println("Elementos na fila: " + filaDinamica);
                break;

             case 5:
                System.out.print("Insira o elemento a ser buscado: ");
                elemento = scanner.nextInt();
                boolean encontrado = filaDinamica.buscar(elemento);
                System.out.println("Elemento " + (encontrado ? "encontrado" : "não encontrado") + " na fila.");
                break;

             case 6:
                Integer maior = filaDinamica.maior();
                System.out.println("Maior elemento na fila: " + maior);
                break;

             case 7:
                Integer menor = filaDinamica.menor();
                System.out.println("Menor elemento na fila: " + menor);
                break;

             case 8:
                Double media = filaDinamica.media();
                System.out.println("Média dos elementos na fila: " + media);
                break;

             case 9:
                int quantidade = filaDinamica.quantidade();
                System.out.println("Quantidade de elementos na fila: " + quantidade);
                break;

             case 0:
                System.out.println("Programa finalizado!");
                break;

             default:
                System.out.println("Opção inválida. Tente novamente.");
          }
       } while(opcao != 0);
       scanner.close();
    }
}