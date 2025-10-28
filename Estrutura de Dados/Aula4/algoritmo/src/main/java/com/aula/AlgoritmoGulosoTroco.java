package com.aula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class AlgoritmoGulosoTroco {



    public List<Integer> resolverTroco(int quantia, int[] moedas) {
        if (quantia <= 0 || moedas == null || moedas.length == 0) {
            return new ArrayList<>();
        }
        
        int[] moedasOrdenadas = Arrays.copyOf(moedas, moedas.length);
        Arrays.sort(moedasOrdenadas);
        reverseArray(moedasOrdenadas);
        
        List<Integer> resultado = new ArrayList<>();
        int quantiaRestante = quantia;
        
        for (int moeda : moedasOrdenadas) {
            while (quantiaRestante >= moeda) {
                resultado.add(moeda);
                quantiaRestante -= moeda;
            }
        }
        
        if (quantiaRestante > 0) {
            System.out.println("AVISO: Não foi possível dar o troco exato. Restam: " + quantiaRestante);
        }
        
        return resultado;
    }
    
    public SolucaoTroco resolverTrocoDetalhado(int quantia, int[] moedas) {
        if (quantia <= 0 || moedas == null || moedas.length == 0) {
            return new SolucaoTroco(new ArrayList<>(), 0, false);
        }
        
        int[] moedasOrdenadas = Arrays.copyOf(moedas, moedas.length);
        Arrays.sort(moedasOrdenadas);
        reverseArray(moedasOrdenadas);
        
        List<Integer> moedasUsadas = new ArrayList<>();
        Map<Integer, Integer> contagemMoedas = new HashMap<>();
        int quantiaRestante = quantia;
        int totalMoedas = 0;
        
        for (int moeda : moedasOrdenadas) {
            while (quantiaRestante >= moeda) {
                moedasUsadas.add(moeda);
                contagemMoedas.put(moeda, contagemMoedas.getOrDefault(moeda, 0) + 1);
                quantiaRestante -= moeda;
                totalMoedas++;
            }
        }
        
        boolean sucesso = (quantiaRestante == 0);
        return new SolucaoTroco(moedasUsadas, totalMoedas, sucesso, contagemMoedas, quantiaRestante);
    }
    
    private void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    public boolean isSistemaCanonico(int[] moedas) {
        if (moedas == null || moedas.length == 0) {
            return false;
        }
        
        int[] moedasOrdenadas = Arrays.copyOf(moedas, moedas.length);
        Arrays.sort(moedasOrdenadas);
        
        for (int i = 1; i <= 100; i++) {
            List<Integer> solucaoGulosa = resolverTroco(i, moedasOrdenadas);
            List<Integer> solucaoOtima = resolverTrocoOtimo(i, moedasOrdenadas);
            
            if (solucaoGulosa.size() != solucaoOtima.size()) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public List<Integer> resolverTrocoOtimo(int quantia, int[] moedas) {
        if (quantia <= 0 || moedas == null || moedas.length == 0) {
            return new ArrayList<>();
        }
        
        int[] dp = new int[quantia + 1];
        int[] parent = new int[quantia + 1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= quantia; i++) {
            for (int moeda : moedas) {
                if (i >= moeda && dp[i - moeda] != Integer.MAX_VALUE) {
                    if (dp[i - moeda] + 1 < dp[i]) {
                        dp[i] = dp[i - moeda] + 1;
                        parent[i] = moeda;
                    }
                }
            }
        }
        
        List<Integer> resultado = new ArrayList<>();
        int current = quantia;
        while (current > 0) {
            if (dp[current] == Integer.MAX_VALUE) {
                return new ArrayList<>(); // Não há solução
            }
            resultado.add(parent[current]);
            current -= parent[current];
        }
        
        return resultado;
    }
    
    public static class SolucaoTroco {
        private final List<Integer> moedasUsadas;
        private final int totalMoedas;
        private final boolean sucesso;
        private final Map<Integer, Integer> contagemMoedas;
        private final int quantiaRestante;
        
        public SolucaoTroco(List<Integer> moedasUsadas, int totalMoedas, boolean sucesso) {
            this.moedasUsadas = moedasUsadas;
            this.totalMoedas = totalMoedas;
            this.sucesso = sucesso;
            this.contagemMoedas = new HashMap<>();
            this.quantiaRestante = 0;
        }
        
        public SolucaoTroco(List<Integer> moedasUsadas, int totalMoedas, boolean sucesso, 
                           Map<Integer, Integer> contagemMoedas, int quantiaRestante) {
            this.moedasUsadas = moedasUsadas;
            this.totalMoedas = totalMoedas;
            this.sucesso = sucesso;
            this.contagemMoedas = contagemMoedas;
            this.quantiaRestante = quantiaRestante;
        }
        
        // Getters
        public List<Integer> getMoedasUsadas() { return moedasUsadas; }
        public int getTotalMoedas() { return totalMoedas; }
        public boolean isSucesso() { return sucesso; }
        public Map<Integer, Integer> getContagemMoedas() { return contagemMoedas; }
        public int getQuantiaRestante() { return quantiaRestante; }
    }
    
    public void testarAlgoritmo() {
        System.out.println("=== TESTE DO ALGORITMO GULOSO PARA TROCO ===\n");
        
        int quantia1 = 18;
        int[] moedas1 = {5, 2, 1};
        System.out.println("Teste 1: Quantia = " + quantia1 + ", Moedas = " + Arrays.toString(moedas1));
        SolucaoTroco solucao1 = resolverTrocoDetalhado(quantia1, moedas1);
        imprimirSolucao(solucao1);
        System.out.println();
        
        int quantia2 = 67;
        int[] moedas2 = {25, 10, 5, 1};
        System.out.println("Teste 2: Quantia = " + quantia2 + ", Moedas = " + Arrays.toString(moedas2));
        SolucaoTroco solucao2 = resolverTrocoDetalhado(quantia2, moedas2);
        imprimirSolucao(solucao2);
        System.out.println();
        
        int quantia3 = 6;
        int[] moedas3 = {4, 3, 1};
        System.out.println("Teste 3: Quantia = " + quantia3 + ", Moedas = " + Arrays.toString(moedas3));
        SolucaoTroco solucao3 = resolverTrocoDetalhado(quantia3, moedas3);
        imprimirSolucao(solucao3);
        
        List<Integer> solucaoOtima = resolverTrocoOtimo(quantia3, moedas3);
        System.out.println("Solução ótima (PD): " + solucaoOtima + " (" + solucaoOtima.size() + " moedas)");
        System.out.println();
        
        int quantia4 = 0;
        int[] moedas4 = {5, 2, 1};
        System.out.println("Teste 4: Quantia = " + quantia4 + ", Moedas = " + Arrays.toString(moedas4));
        SolucaoTroco solucao4 = resolverTrocoDetalhado(quantia4, moedas4);
        imprimirSolucao(solucao4);
        System.out.println();
        
        System.out.println("Verificação de sistemas canônicos:");
        System.out.println("Sistema [25,10,5,1] é canônico: " + isSistemaCanonico(new int[]{25,10,5,1}));
        System.out.println("Sistema [4,3,1] é canônico: " + isSistemaCanonico(new int[]{4,3,1}));
        System.out.println();
    }
    
    private void imprimirSolucao(SolucaoTroco solucao) {
        if (solucao.isSucesso()) {
            System.out.println("Moedas usadas: " + solucao.getMoedasUsadas());
            System.out.println("Total de moedas: " + solucao.getTotalMoedas());
            System.out.println("Contagem por moeda: " + solucao.getContagemMoedas());
        } else {
            System.out.println("Não foi possível dar o troco exato.");
            System.out.println("Quantia restante: " + solucao.getQuantiaRestante());
        }
    }
    
    public void analisarComplexidade() {
        System.out.println("=== ANÁLISE DE COMPLEXIDADE ===\n");
        
        System.out.println("ALGORITMO GULOSO PARA TROCO:");
        System.out.println("- Tempo: O(n) onde n é o número de tipos de moedas");
        System.out.println("- Espaço: O(n) para armazenar o resultado");
        System.out.println();
        
        System.out.println("ESTRATÉGIA GULOSA:");
        System.out.println("1. Ordena as moedas em ordem decrescente");
        System.out.println("2. Sempre escolhe a maior moeda possível");
        System.out.println("3. Repete até completar a quantia");
        System.out.println();
        
        System.out.println("VANTAGENS:");
        System.out.println("- Simples de implementar");
        System.out.println("- Muito eficiente (O(n))");
        System.out.println("- Funciona perfeitamente para sistemas canônicos");
        System.out.println();
        
        System.out.println("DESVANTAGENS:");
        System.out.println("- Não funciona para todos os sistemas de moedas");
        System.out.println("- Pode não encontrar a solução ótima");
        System.out.println("- Exemplo: moedas [4,3,1], quantia 6");
        System.out.println("  * Guloso: [4,1,1] (3 moedas)");
        System.out.println("  * Ótimo: [3,3] (2 moedas)");
        System.out.println();
        
        System.out.println("SISTEMAS CANÔNICOS:");
        System.out.println("- Algoritmo guloso sempre encontra a solução ótima");
        System.out.println("- Exemplos: [25,10,5,1] (sistema americano)");
        System.out.println("- Exemplos: [50,25,10,5,1] (sistema brasileiro)");
        System.out.println();
        
        System.out.println("QUANDO USAR:");
        System.out.println("- Sistemas de moedas canônicos");
        System.out.println("- Quando eficiência é prioridade");
        System.out.println("- Para valores pequenos onde a diferença é mínima");
    }
}
