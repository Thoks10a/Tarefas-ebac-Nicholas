package com.carros.veiculo;

public class caminhonete extends carro {

    private double capacidadeDeCarga;

    public caminhonete(String marca, String modelo, int ano, double capacidadeDeCarga) {
        super(marca, modelo, ano);
        this.capacidadeDeCarga = capacidadeDeCarga;
    }

    public double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    @Override
    public String toString() {
        return "Caminhonete{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", capacidadeDeCarga=" + capacidadeDeCarga +
                '}';
    }

}
