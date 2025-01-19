package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

    String value = "Teste";

    public String[] main() {
        // Scanner sc = new Scanner(System.in);
        testReceive tr = new testReceive();
        // ArrayList arr = new ArrayList();
        ;
        // Segunda Parte
        System.out.println("====================================================");
        System.out.println("=======================Segunda Parte=============================");

        System.out.println("Digite o nome o gênero(Carlos-M,Ana-F): ");
        // String nomesGenero = sc.nextLine();
        String nomesGenero = "Renato-M,Marta-F,Thiago-M,Maisa-F";
        String[] nomesGeneroSplit = nomesGenero.split(",");

        List<String> nomesMasculinos = new ArrayList<>();
        List<String> nomesFeminino = new ArrayList<>();

        for (String entrada : nomesGeneroSplit) {
            if (entrada.endsWith("-M")) {
                nomesMasculinos.add(entrada.substring(0, entrada.length() - 2));
            } else if (entrada.endsWith("-F")) {
                nomesFeminino.add(entrada.substring(0, entrada.length() - 2));
            }

        }
        System.out.println("====================================================");
        System.out.println("Nomes masculinos: " + nomesMasculinos);
        System.out.println("Nomes femininos: " + nomesFeminino);
        System.out.println("=========================Usando Stream===========================");
        List<String> total = new ArrayList<>();
        for (String entrada : nomesGeneroSplit) {
            total.add(entrada);
        }
        // total.forEach(System.out::println);
        String[] totalr = total.stream().filter(t -> t.endsWith("-F")).toArray(size -> new String[size]);
        Arrays.stream(totalr).forEach(System.out::println);
        tr.setValue(totalr);
        Stream<String> total2 = total.stream().filter(t -> t.endsWith("-F"))
                .map(t -> t.substring(0, t.length() - 2));
        total2.forEach(System.out::println);
        System.out.println("====================================================");
        System.out.println("====================================================");
        return totalr;
    }
}
