package com.aula2;

public class pilha {

    
    private int[] value;

    public pilha(int size) {
        this.value = new int[size];
    }

    public void reajuste(){
        int[] supvalue = new int[this.value.length];
        for(int i = 0; i < this.value.length; i++){
            supvalue[i] = 0;
        }
        for(int i = this.value.length-1; i >= 0; i--){
            for(int j = supvalue.length-1; j >= 0; j--){
                if(this.value[i] != 0){
                    if(supvalue[j] == 0){
                        supvalue[j] = this.value[i];
                        break;
                    }
                }
                
            }
        }
        this.value = supvalue;
    }

    public void createPilha(int value, int index) {
        System.out.println("Inserindo valor na pilha: " + value);
        this.value[index] = value;
    }
    
    public void push(int value) {
        for (int i = 0; i < this.value.length; i++) {
            if(this.value[i] == 0){
                for(int j = 0; j < this.value.length; j++){
                    if(this.value[j] != 0){
                        this.value[j-1] = this.value[j];
                        //System.out.println("AQUI: " + this.value[j]);
                    }
                }
                this.value[this.value.length-1] = value;
                System.out.println("Valor inserido na casa: " + i + " da pilha: " + this.value[i]);
                break;
            }else{
                System.out.println("Pilha cheia!");
                break;
            }
        }
        this.reajuste();
    }

    public void pop() {
        for (int i = this.value.length-1; i >= 0; i--) {
            if(this.value[i] != 0){
                this.value[i] = 0;
                System.out.println("Valor removido da casa: " + i + " da pilha");
                break;
            }
        }
        this.reajuste();
    }

    public void top(){
        System.out.println("Valor do topo da pilha: " + this.value[this.value.length-1]);
    }

    public void isEmpty() {
        if(this.value[0] == 0){
            System.out.println("Pilha vazia!");
        }else{
            System.out.println("Pilha nao vazia!");
        }
    }

    public void size(){
        System.out.println("Tamanho da pilha: " + this.value.length);
    }
    
    public void print() {
        System.out.println("↓Valores da pilha↓: ");
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
        System.out.println("🠕Valores da pilha🠕: ");
    }
    

}
