package com.audrey_brayan_sara_sebas_andres.Models;

public enum FrecuenciaConsumo {
    DIARIO(7), CUATRO_SEIS(5), UNO_TRES(2), NINGUNO(0);

    private final int dias;

    FrecuenciaConsumo(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}
