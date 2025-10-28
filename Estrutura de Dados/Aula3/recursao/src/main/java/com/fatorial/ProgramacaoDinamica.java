package com.fatorial;

public class ProgramacaoDinamica {

    public int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int fibonacci2(int n){
        int memory[] = new int[n+1];
        for(int i = 0; i < memory.length; i++) {
        }
        return fibDinamic(n, memory);
    }

    public int fibDinamic(int n, int memory[]){
        if(n == 0 || n == 1) {
            return n;
        }
        if(memory[n] != 0) {
            return memory[n];
        }
        memory[n] = fibDinamic(n-1, memory) + fibDinamic(n-2, memory);
        return memory[n];
    }

    public int product1ToN(int n) {
        // we assume n >= 1
    
        int result = 1;
        for (int num = 1; num <= n; num++) {
            result *= num;
        }
    
        return result;
    }
    
}
