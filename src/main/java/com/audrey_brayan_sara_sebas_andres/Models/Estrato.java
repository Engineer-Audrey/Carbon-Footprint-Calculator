package com.audrey_brayan_sara_sebas_andres.Models;


public enum Estrato {
    UNO(354.7, 2800, 1500),
    DOS(443.4, 2900, 2800),
    TRES(739.4, 3000, 3000),
    CUATRO(869.5, 3100, 4000),
    CINCO(1043, 3200, 5000),
    SEIS(1043, 3200, 5000);

    private final double costoKWh;
    private final double costoGas;
    private final double costoAgua;

    Estrato(double costoKWh, double costoGas, double costoAgua) {
        this.costoKWh = costoKWh;
        this.costoGas = costoGas;
        this.costoAgua = costoAgua;
    }

    public double getCostoKWh() {
        return costoKWh;
    }

    public double getCostoGas() {
        return costoGas;
    }

    public double getCostoAgua() {
        return costoAgua;
    }
}
