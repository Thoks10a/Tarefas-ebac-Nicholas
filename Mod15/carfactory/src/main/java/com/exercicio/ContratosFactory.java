package com.exercicio;

public class ContratosFactory extends Factory {
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new CorolaCar(100, 4, "azul");
        } else {
            return new Ferrari(500, 2, "vermelho");
        }
    }

    @Override
    Motocycle retrieveMotorcycle(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Scooter(70, false, "azul");
        } else {
            return null;
        }
    }
}
