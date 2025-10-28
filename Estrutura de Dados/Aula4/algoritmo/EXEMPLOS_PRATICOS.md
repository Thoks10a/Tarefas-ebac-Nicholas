# Exemplos Práticos - Algoritmos de Backtracking e Guloso

## 1. Algoritmo de Backtracking para Subconjuntos

### Problema
Dado um conjunto S de elementos únicos, calcular todos os seus subconjuntos de n elementos.

### Exemplo
- **Entrada:** S = [1,2,3], n = 2
- **Saída:** [[1,2], [1,3], [2,3]]

### Implementação
```java
// Método principal
public List<List<Integer>> gerarSubconjuntos(int[] conjunto, int n) {
    List<List<Integer>> resultado = new ArrayList<>();
    List<Integer> subconjuntoAtual = new ArrayList<>();
    backtrack(conjunto, n, 0, subconjuntoAtual, resultado);
    return resultado;
}

// Método recursivo de backtracking
private void backtrack(int[] conjunto, int n, int indice, 
                      List<Integer> subconjuntoAtual, 
                      List<List<Integer>> resultado) {
    
    // Condição de parada: subconjunto tem tamanho n
    if (subconjuntoAtual.size() == n) {
        resultado.add(new ArrayList<>(subconjuntoAtual));
        return;
    }
    
    // Poda: não é possível formar subconjunto de tamanho n
    if (subconjuntoAtual.size() + (conjunto.length - indice) < n) {
        return;
    }
    
    // Opção 1: Incluir elemento atual
    subconjuntoAtual.add(conjunto[indice]);
    backtrack(conjunto, n, indice + 1, subconjuntoAtual, resultado);
    
    // Backtrack: remover elemento
    subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
    
    // Opção 2: Não incluir elemento atual
    backtrack(conjunto, n, indice + 1, subconjuntoAtual, resultado);
}
```

### Complexidade
- **Tempo:** O(C(m,n)) onde m = tamanho do conjunto, n = tamanho do subconjunto
- **Espaço:** O(n) para pilha de recursão + O(C(m,n)) para resultados

### Exemplos de Uso
```java
BacktrackingSubconjuntos algoritmo = new BacktrackingSubconjuntos();

// Exemplo 1: S = [1,2,3], n = 2
int[] conjunto1 = {1, 2, 3};
List<List<Integer>> resultado1 = algoritmo.gerarSubconjuntos(conjunto1, 2);
// Resultado: [[1,2], [1,3], [2,3]]

// Exemplo 2: S = [1,2,3,4], n = 2
int[] conjunto2 = {1, 2, 3, 4};
List<List<Integer>> resultado2 = algoritmo.gerarSubconjuntos(conjunto2, 2);
// Resultado: [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]]
```

---

## 2. Algoritmo Guloso para Problema do Troco

### Problema
Dar o troco de uma quantia em dinheiro usando o menor número possível de moedas.

### Exemplo
- **Entrada:** quantia = 18, moedas = [5,2,1]
- **Saída:** [5,5,5,2,1] (5 moedas no total)

### Implementação
```java
public List<Integer> resolverTroco(int quantia, int[] moedas) {
    // Ordena moedas em ordem decrescente
    int[] moedasOrdenadas = Arrays.copyOf(moedas, moedas.length);
    Arrays.sort(moedasOrdenadas);
    reverseArray(moedasOrdenadas);
    
    List<Integer> resultado = new ArrayList<>();
    int quantiaRestante = quantia;
    
    // Estratégia gulosa: sempre escolhe a maior moeda possível
    for (int moeda : moedasOrdenadas) {
        while (quantiaRestante >= moeda) {
            resultado.add(moeda);
            quantiaRestante -= moeda;
        }
    }
    
    return resultado;
}
```

### Complexidade
- **Tempo:** O(n) onde n é o número de tipos de moedas
- **Espaço:** O(n) para armazenar o resultado

### Exemplos de Uso
```java
AlgoritmoGulosoTroco algoritmo = new AlgoritmoGulosoTroco();

// Exemplo 1: Sistema canônico
int quantia1 = 18;
int[] moedas1 = {5, 2, 1};
List<Integer> resultado1 = algoritmo.resolverTroco(quantia1, moedas1);
// Resultado: [5, 5, 5, 2, 1] (5 moedas)

// Exemplo 2: Sistema americano
int quantia2 = 67;
int[] moedas2 = {25, 10, 5, 1};
List<Integer> resultado2 = algoritmo.resolverTroco(quantia2, moedas2);
// Resultado: [25, 25, 10, 5, 1, 1] (6 moedas)
```

---

## Comparação de Algoritmos

### Backtracking vs Guloso

| Aspecto | Backtracking | Guloso |
|---------|--------------|--------|
| **Estratégia** | Explora todas as possibilidades | Escolhe a melhor opção local |
| **Complexidade** | Exponencial no pior caso | Linear |
| **Garantia** | Sempre encontra solução ótima | Pode não ser ótima |
| **Uso** | Problemas de decisão/otimização | Problemas com propriedade gulosa |

### Quando Usar Cada Um

#### Backtracking
- Problemas de combinação/permutação
- Quando precisa de todas as soluções
- Quando a solução ótima é essencial
- Exemplos: N-Queens, Sudoku, Labirinto

#### Guloso
- Problemas com propriedade gulosa
- Quando eficiência é prioridade
- Quando a solução "boa o suficiente" é aceitável
- Exemplos: Troco, Árvore geradora mínima, Código de Huffman

---

## Testes Realizados

### Backtracking - Subconjuntos
```
Teste 1: S = [1,2,3], n = 2
Resultado: [[1,2], [1,3], [2,3]] ✓

Teste 2: S = [1,2,3,4], n = 2  
Resultado: [[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]] ✓

Teste 3: S = [1,2,3,4,5], n = 3
Resultado: 10 subconjuntos ✓
```

### Guloso - Troco
```
Teste 1: Quantia = 18, Moedas = [5,2,1]
Resultado: [5,5,5,2,1] (5 moedas) ✓

Teste 2: Quantia = 67, Moedas = [25,10,5,1]
Resultado: [25,25,10,5,1,1] (6 moedas) ✓

Teste 3: Quantia = 6, Moedas = [4,3,1]
Resultado: [4,1,1] (3 moedas) - Não ótima
Ótima: [3,3] (2 moedas) ✓
```

---

## Conclusões

1. **Backtracking** é ideal para problemas onde precisamos explorar todas as possibilidades e garantir a solução ótima.

2. **Algoritmo Guloso** é ideal para problemas com propriedade gulosa, onde a escolha local ótima leva à solução global ótima.

3. Ambos os algoritmos foram implementados com otimizações e análises de complexidade detalhadas.

4. Os testes demonstram que os algoritmos funcionam corretamente para os casos de uso especificados.
