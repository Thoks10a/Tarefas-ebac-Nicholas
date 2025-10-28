package com.aula2;

public class lista<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void pop() {
        if(this.head == null) {
            System.out.println("Lista vazia!");
        } else {
            this.head = this.head.getNext();
            if(this.head == null) {
                this.tail = null;
            }
        }
    }

    void insert(T value, int index) {
        Node<T> newNode = new Node<T>(value);
        if(index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node<T> current = this.head;
        }
    }

    void remove(int index) {
        if(index == 0) {
            this.head = this.head.getNext();
            if(this.head == null) {
                this.tail = null;
            }
        }
    }

    public T elementAt(int index) {
        Node<T> current = this.head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public int size() {
        Node<T> current = this.head;
        int size = 0;
        while(current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void print() {
        Node<T> current = this.head;
        while(current != null) {
            current.print();
            current = current.getNext();
        }
    }
}
