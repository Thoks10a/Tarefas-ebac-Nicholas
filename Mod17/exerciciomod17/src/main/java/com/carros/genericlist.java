package com.carros;

import java.util.ArrayList;
import java.util.List;

public class genericlist<T> {

    private List<T> lista = new ArrayList<>();

    public void adicionar(T item) {
        lista.add(item);
    }

    public T obter(int indice) {
        if (indice >= 0 && indice < lista.size()) {
            return lista.get(indice);
        }
        return null;
    }

    public List<T> obterTodos() {
        return lista;
    }

    @Override
    public String toString() {
        return "ListaGenerica{" +
                "lista=" + lista +
                '}';
    }

}
