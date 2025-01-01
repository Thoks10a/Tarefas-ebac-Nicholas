package com.exercicio;

public class ContratosFactory extends Factory {
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new CorolaCar(100, 4, "azul");
        } else {
            return null;
        }
    }

    @Override
    Motocycle retrieveMotorcycle(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Scooter(70, false, "verde");
        } else {
            return null;
        }
    }
}
