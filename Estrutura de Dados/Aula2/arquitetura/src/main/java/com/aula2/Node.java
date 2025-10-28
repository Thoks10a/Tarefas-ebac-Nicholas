package com.aula2;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void print() {
        System.out.println("Valor do nodo: " + this.value);
    }

    public void printNext() {
        if(this.next != null){
            System.out.println("Valor do nodo seguinte: " + this.next.value);
        }else{
            System.out.println("Não há nodo seguinte");
        }
    }
}
