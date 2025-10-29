package com.aula;

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
        calc calc = new calc();
        System.out.println("Digite o numero que deseja:");
        int n = scanner.nextInt();
        while (true) { 
            System.out.println("Digite a operação que deseja:");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Mostrar numero atual");
            System.out.println("6 - Sair");
            int op = scanner.nextInt();
            if(op == 1) {
                System.out.println("Digite o numero que deseja somar: ");
                int n1 = scanner.nextInt();
                System.out.println("O resultado da soma é: " + calc.soma(n, n1));
            }
            if(op == 2) {
                System.out.println("Digite o numero que deseja subtrair: ");
                int n1 = scanner.nextInt();
                System.out.println("O resultado da subtração é: " + calc.subtracao(n, n1));
            }
            if(op == 3) {
                System.out.println("Digite o numero que deseja multiplicar: ");
                int n1 = scanner.nextInt();
                System.out.println("O resultado da multiplicação é: " + calc.multiplicacao(n, n1));
            }
            if(op == 4) {
                System.out.println("Digite o numero que deseja dividir: ");
                int n1 = scanner.nextInt();
                System.out.println("O resultado da divisão é: " + calc.divisao(n, n1));
            }
            if(op == 5) {
                System.out.println("Numero atual: " + n);
            }
            if(op == 6) {
                break;
            }
        }
    }
}   
