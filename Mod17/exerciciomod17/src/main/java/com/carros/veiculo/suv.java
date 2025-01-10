package com.carros.veiculo;

public class suv extends carro {

    private boolean temTraçãoNasQuatroRodas;

    public suv(String marca, String modelo, int ano, boolean temTraçãoNasQuatroRodas) {
        super(marca, modelo, ano);
        this.temTraçãoNasQuatroRodas = temTraçãoNasQuatroRodas;
    }

    public boolean temTraçãoNasQuatroRodas() {
        return temTraçãoNasQuatroRodas;
    }

    @Override
    public String toString() {
        return "SUV{" +
                "marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", temTraçãoNasQuatroRodas=" + temTraçãoNasQuatroRodas +
                '}';
    }

}
