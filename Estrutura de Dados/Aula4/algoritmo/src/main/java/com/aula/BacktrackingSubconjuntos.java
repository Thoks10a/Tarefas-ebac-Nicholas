package com.aula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackingSubconjuntos {

    public List<List<Integer>> gerarSubconjuntos(int[] conjunto, int n) {
        if (conjunto == null || conjunto.length == 0 || n <= 0 || n > conjunto.length) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> resultado = new ArrayList<>();
        List<Integer> subconjuntoAtual = new ArrayList<>();
        
        backtrack(conjunto, n, 0, subconjuntoAtual, resultado);
        
        return resultado;
    }
    
    private void backtrack(int[] conjunto, int n, int indice, 
                          List<Integer> subconjuntoAtual, 
                          List<List<Integer>> resultado) {
        
        if (subconjuntoAtual.size() == n) {
            resultado.add(new ArrayList<>(subconjuntoAtual));
            return;
        }
        
        if (indice >= conjunto.length) {
            return;
        }
        
        if (subconjuntoAtual.size() + (conjunto.length - indice) < n) {
            return;
        }
        
        subconjuntoAtual.add(conjunto[indice]);
        backtrack(conjunto, n, indice + 1, subconjuntoAtual, resultado);
        
        subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        
        backtrack(conjunto, n, indice + 1, subconjuntoAtual, resultado);
    }
    
    public List<List<Integer>> gerarSubconjuntosIterativo(int[] conjunto, int n) {
        if (conjunto == null || conjunto.length == 0 || n <= 0 || n > conjunto.length) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> resultado = new ArrayList<>();
        int m = conjunto.length;
        
        for (int i = 0; i < (1 << m); i++) {
            if (Integer.bitCount(i) == n) {
                List<Integer> subconjunto = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) != 0) {
                        subconjunto.add(conjunto[j]);
                    }
                }
                resultado.add(subconjunto);
            }
        }
        
        return resultado;
    }
    
    public void imprimirSubconjuntos(List<List<Integer>> subconjuntos) {
        System.out.println("Subconjuntos encontrados: " + subconjuntos.size());
        System.out.print("[");
        for (int i = 0; i < subconjuntos.size(); i++) {
            System.out.print(subconjuntos.get(i));
            if (i < subconjuntos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public void testarAlgoritmo() {
        System.out.println("=== TESTE DO ALGORITMO DE BACKTRACKING PARA SUBCONJUNTOS ===\n");
        
        int[] conjunto1 = {1, 2, 3};
        int n1 = 2;
        System.out.println("Teste 1: S = " + Arrays.toString(conjunto1) + ", n = " + n1);
        List<List<Integer>> resultado1 = gerarSubconjuntos(conjunto1, n1);
        imprimirSubconjuntos(resultado1);
        System.out.println();
        
        int[] conjunto2 = {1, 2, 3, 4};
        int n2 = 2;
        System.out.println("Teste 2: S = " + Arrays.toString(conjunto2) + ", n = " + n2);
        List<List<Integer>> resultado2 = gerarSubconjuntos(conjunto2, n2);
        imprimirSubconjuntos(resultado2);
        System.out.println();
        
        int[] conjunto3 = {1, 2, 3, 4, 5};
        int n3 = 3;
        System.out.println("Teste 3: S = " + Arrays.toString(conjunto3) + ", n = " + n3);
        List<List<Integer>> resultado3 = gerarSubconjuntos(conjunto3, n3);
        imprimirSubconjuntos(resultado3);
        System.out.println();
        
        int[] conjunto4 = {1, 2, 3, 4};
        int n4 = 2;
        System.out.println("Teste 4: Comparação de métodos");
        System.out.println("S = " + Arrays.toString(conjunto4) + ", n = " + n4);
        
        long startTime = System.nanoTime();
        List<List<Integer>> recursivo = gerarSubconjuntos(conjunto4, n4);
        long endTime = System.nanoTime();
        System.out.println("Método recursivo: " + (endTime - startTime) + " ns");
        
        startTime = System.nanoTime();
        List<List<Integer>> iterativo = gerarSubconjuntosIterativo(conjunto4, n4);
        endTime = System.nanoTime();
        System.out.println("Método iterativo: " + (endTime - startTime) + " ns");
        
        System.out.println("Resultados são iguais: " + recursivo.equals(iterativo));
        System.out.println();
    }
    
    public void analisarComplexidade() {
        System.out.println("=== ANÁLISE DE COMPLEXIDADE ===\n");
        
        System.out.println("ALGORITMO DE BACKTRACKING PARA SUBCONJUNTOS:");
        System.out.println("- Tempo: O(C(m,n)) onde m = tamanho do conjunto, n = tamanho do subconjunto");
        System.out.println("- Espaço: O(n) para pilha de recursão + O(C(m,n)) para resultados");
        System.out.println("- C(m,n) = m! / (n! * (m-n)!) é o número de combinações");
        System.out.println();
        
        System.out.println("EXEMPLOS DE COMPLEXIDADE:");
        System.out.println("- S = [1,2,3], n = 2: C(3,2) = 3 subconjuntos");
        System.out.println("- S = [1,2,3,4], n = 2: C(4,2) = 6 subconjuntos");
        System.out.println("- S = [1,2,3,4,5], n = 3: C(5,3) = 10 subconjuntos");
        System.out.println();
        
        System.out.println("OTIMIZAÇÕES IMPLEMENTADAS:");
        System.out.println("1. Poda: Se não é possível formar subconjunto de tamanho n com elementos restantes");
        System.out.println("2. Backtrack: Remove elemento após testar para tentar outras opções");
        System.out.println("3. Condições de parada: Evita chamadas desnecessárias");
        System.out.println();
        
        System.out.println("VANTAGENS:");
        System.out.println("- Gera apenas os subconjuntos necessários");
        System.out.println("- Usa poda para evitar caminhos inválidos");
        System.out.println("- Estrutura recursiva clara e intuitiva");
        System.out.println();
        
        System.out.println("DESVANTAGENS:");
        System.out.println("- Usa pilha de recursão (pode causar estouro para conjuntos muito grandes)");
        System.out.println("- Complexidade exponencial no pior caso");
    }
}
