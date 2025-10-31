package com.audrey_brayan_sara_sebas_andres.Models;

public enum TipoVehiculo {
    CARRO(0.1),
    MOTO(0.25),
    NINGUNO(0.0);

    private final double factorEmision;

    TipoVehiculo(double factorEmision) {
        this.factorEmision = factorEmision;
    }

    public double getFactorEmision() {
        return factorEmision;
    }
}

