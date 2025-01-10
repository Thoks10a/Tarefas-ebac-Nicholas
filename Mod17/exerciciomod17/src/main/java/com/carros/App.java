package com.carros;

import com.carros.veiculo.caminhonete;
import com.carros.veiculo.carro;
import com.carros.veiculo.sedan;
import com.carros.veiculo.suv;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        genericlist<carro> listaDeCarros = new genericlist<>();

        sedan sedanc = new sedan("Toyota", "Corolla", 2020, true);
        suv suvc = new suv("Honda", "CR-V", 2021, true);
        caminhonete caminhonetec = new caminhonete("Ford", "Ranger", 2019, 1000.5);

        listaDeCarros.adicionar(sedanc);
        listaDeCarros.adicionar(suvc);
        listaDeCarros.adicionar(caminhonetec);

        System.out.println("Lista de Carros:");
        for (carro carro : listaDeCarros.obterTodos()) {
            System.out.println(carro);
        }

        // Obter um carro específico pelo índice
        carro carroObtido = listaDeCarros.obter(1);
        System.out.println("Carro obtido pelo índice 1: " + carroObtido);

    }
}
