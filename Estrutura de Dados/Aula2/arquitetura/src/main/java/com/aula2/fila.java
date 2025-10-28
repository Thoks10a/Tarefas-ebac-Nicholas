package com.aula2;

public class fila {

    private int[] value;

    public fila(int size) {
        this.value = new int[size];
    }

    public void createFila(int value, int index) {
        System.out.println("Inserindo valor na fila: " + value);
        this.value[index] = value;
    }

    public void enqueue(int value) {
        for (int i = 0; i < this.value.length; i++) {
            if(this.value[i] == 0){
                this.value[i] = value;
                System.out.println("Valor inserido na casa: " + i + " da fila: " + this.value[i]);
                break;
            }
        }
    }

    public void dequeue() {
        for (int i = this.value.length-1; i >= 0; i--) {
            if(this.value[i] != 0){
                this.value[i] = 0;
                System.out.println("Valor removido da casa: " + i + " da fila");
                break;
            }
        }
    }

    public void front() {
        System.out.println("Valor do topo da fila: " + this.value[0]);
    }

    public void rear() {
        System.out.println("Valor do final da fila: " + this.value[this.value.length-1]);
    }

    public void isEmpty() {
        if(this.value[0] == 0){
            System.out.println("Fila vazia!");
        }else{
            System.out.println("Fila nao vazia!");
        }
    }

    public void print() {
        System.out.println("↓Valores da fila↓: ");
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
        System.out.println("🠕Valores da fila🠕: ");
    }

    public void size() {
        System.out.println("Tamanho da fila: " + this.value.length);
    }
}
