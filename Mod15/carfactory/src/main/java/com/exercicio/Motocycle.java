package com.exercicio;

public abstract class Motocycle {
    private int horsePower;
    private Boolean chest;
    private String color;

    public Motocycle(int horsePower, Boolean chest, String color) {
        this.horsePower = horsePower;
        this.chest = chest;
        this.color = color;
    }

    public void startEngine() {
        System.out.println(getClass().getSimpleName());
        System.out.println(
                "The motorcycle has a" + chest + " engine has been started, and is ready to utilize " + horsePower
                        + " horsepowers.n");
    }

    public void clean() {
        System.out.println("Motorcycle has been cleaned, and the " + color.toLowerCase() + " color shines");
    }

    public void mechanicCheck() {
        System.out.println("Motorcycle has been checked by the mechanic. Everything looks good!");
    }
}
