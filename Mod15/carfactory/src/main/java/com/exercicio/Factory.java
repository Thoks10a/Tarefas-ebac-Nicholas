package com.exercicio;

public abstract class Factory {

    public Motocycle createMotorcycle(String requestedGrade) {
        Motocycle motorcycle = retrieveMotorcycle(requestedGrade);
        motorcycle = prepareCar(motorcycle);
        return motorcycle;
    }

    private Motocycle prepareCar(Motocycle motorcycle) {
        motorcycle.clean();
        motorcycle.mechanicCheck();
        return motorcycle;
    }

    abstract Motocycle retrieveMotorcycle(String requestedGrade);

    public Car create(String requestedGrade) {
        Car car = retrieveCar(requestedGrade);
        car = prepareCar(car);
        return car;
    }

    private Car prepareCar(Car car) {
        car.clean();
        car.mechanicCheck();
        return car;
    }

    abstract Car retrieveCar(String requestedGrade);
}
