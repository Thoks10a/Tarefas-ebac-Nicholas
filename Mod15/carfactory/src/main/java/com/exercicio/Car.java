package com.exercicio;

public abstract class Car {
    private int horsePower;
    private int NPorts;
    private String color;

    public Car(int horsePower, int NPorts, String color) {
        this.horsePower = horsePower;
        this.NPorts = NPorts;
        this.color = color;
    }

    public void startEngine() {
        System.out.println(getClass().getSimpleName());
        System.out.println(
                "The car has " + NPorts + " do0rs," + " engine has been started, and is ready to utilize " + horsePower
                        + " horsepowers.n");
    }

    public void clean() {
        System.out.println("Car has been cleaned, and the " + color.toLowerCase() + " color shines");
    }

    public void mechanicCheck() {
        System.out.println("Car has been checked by the mechanic. Everything looks good!");
    }

}
