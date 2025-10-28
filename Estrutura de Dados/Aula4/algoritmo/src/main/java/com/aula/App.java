package com.aula;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=== DEMONSTRAÇÃO DE ALGORITMOS DE BACKTRACKING E GULOSO ===\n");
        
        System.out.println("1. ALGORITMO DE BACKTRACKING PARA SUBCONJUNTOS");
        System.out.println("=" .repeat(60));
        BacktrackingSubconjuntos backtracking = new BacktrackingSubconjuntos();
        backtracking.testarAlgoritmo();
        backtracking.analisarComplexidade();
        
        System.out.println("\n" + "=".repeat(80) + "\n");
        
        System.out.println("2. ALGORITMO GULOSO PARA PROBLEMA DO TROCO");
        System.out.println("=" .repeat(50));
        AlgoritmoGulosoTroco guloso = new AlgoritmoGulosoTroco();
        guloso.testarAlgoritmo();
        guloso.analisarComplexidade();
        
        System.out.println("\n=== DEMONSTRAÇÃO CONCLUÍDA ===");
    }
}
