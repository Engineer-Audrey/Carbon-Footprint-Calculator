package com.audrey_brayan_sara_sebas_andres.Models;

public enum TipoRopa {
    IMPORTADA(55), NACIONAL(35), SEGUNDA_MANO(8), REUTILIZADA(4);

    private final double emisionesUnitarias;

    TipoRopa(double emisionesUnitarias) {
        this.emisionesUnitarias = emisionesUnitarias;
    }

    public double getEmisionesUnitarias() {
        return emisionesUnitarias;
    }
}