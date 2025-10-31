package com.audrey_brayan_sara_sebas_andres.Models;

public enum UsoPlastico {
    DIARIO(45), SEMANAL(9), RARA_VEZ(1), NINGUNO(0);

    private final double emisiones;

    UsoPlastico(double emisiones) {
        this.emisiones = emisiones;
    }

    public double getEmisiones() {
        return emisiones;
    }
}