package com.aula2;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        /* 
        //lista encadeada
        lista<Integer> lista = new lista<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.insert(4, 1);
        lista.remove(2);
        System.out.println("Elemento na posição 1: " + lista.elementAt(1));
        System.out.println("Tamanho da lista: " + lista.size());
        lista.print();*/

        
        //fila fifo
        System.out.println("Digite o tamanho da fila: ");
        int sizefila = scanner.nextInt();
        fila fila = new fila(sizefila);
        System.out.println("Digite os valores a serem inseridos na fila: ");
        for (int i = 0; i < sizefila; i++) {
            int value = scanner.nextInt();
            fila.createFila(value, i);
        }
        while (true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Inserir valor na fila");
            System.out.println("2 - Remover valor da fila");
            System.out.println("3 - Imprimir valores da fila");
            System.out.println("4 - Mostrar valor do topo da fila");
            System.out.println("5 - Mostrar valor do final da fila");
            System.out.println("6 - Verificar se a fila esta vazia");
            System.out.println("7 - Mostrar tamanho da fila");
            System.out.println("8 - Sair");
            int optionfila = scanner.nextInt();
            if (optionfila == 1) {
                System.out.println("Digite o valor a ser inserido na fila: ");
                int value = scanner.nextInt();
                fila.enqueue(value);
            }
            if (optionfila == 2) {
                fila.dequeue();
            }
            if (optionfila == 3) {
                fila.print();
            }
            if (optionfila == 4) {
                fila.front();
            }
            if (optionfila == 5) {
                fila.rear();
            }
            if (optionfila == 6) {
                fila.isEmpty();
            }
            if (optionfila == 7) {
                fila.size();
            }
            if (optionfila == 8) {
                break;
            }
        }
    


        /* 
        //pilha
        System.out.println("Digite o tamanho da pilha: ");
        int size = scanner.nextInt();
        pilha pilha = new pilha(size);
        System.out.println("Digite os valores a serem inseridos na pilha: ");
        for (int i = 0; i < size; i++) {
            int value = scanner.nextInt();
            pilha.createPilha(value, i);
        }
        while (true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Inserir valor na pilha");
            System.out.println("2 - Remover valor da pilha");
            System.out.println("3 - Imprimir valores da pilha");
            System.out.println("4 - Mostrar valor do topo da pilha");
            System.out.println("5 - Verificar se a pilha esta vazia");
            System.out.println("6 - Mostrar tamanho da pilha");
            System.out.println("7 - Sair");
            int option = scanner.nextInt();
        
        if (option == 1) {
            System.out.println("Digite o valor a ser inserido na pilha: ");
            int value = scanner.nextInt();
            pilha.push(value);
        }
        if (option == 2) {
            pilha.pop();
        }
        if (option == 3) {
            pilha.print();
        }
        if (option == 4) {
            pilha.top();
        }
        if (option == 5) {
            pilha.isEmpty();
        }
        if (option == 6) {
            pilha.size();
        }
        if (option == 7) {
            break;
        }
    }*/
    }
}
