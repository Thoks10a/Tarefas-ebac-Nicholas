package com.exercicio;

public class SemContratosFactory extends Factory {
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Brasilia(100, 4, "azul");
        } else {
            return null;
        }
    }

    @Override
    Motocycle retrieveMotorcycle(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Scooter(70, true, "azul");
        } else {
            return null;
        }
    }
}
