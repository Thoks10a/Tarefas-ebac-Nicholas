package com.carros.veiculo;

public class sedan extends carro {

    private boolean temPortaMalasGrande;

    public sedan(String marca, String modelo, int ano, boolean temPortaMalasGrande) {
        super(marca, modelo, ano);
        this.temPortaMalasGrande = temPortaMalasGrande;
    }

    public boolean temPortaMalasGrande() {
        return temPortaMalasGrande;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", temPortaMalasGrande=" + temPortaMalasGrande +
                '}';
    }

}
