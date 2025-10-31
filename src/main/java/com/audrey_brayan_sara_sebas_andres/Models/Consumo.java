package com.audrey_brayan_sara_sebas_andres.Models;

public class Consumo {

    private UsoPlastico usoPlastico;
    private TipoRopa tipoRopa;
    private FrecuenciaConsumo frecuenciaRopa;
    private FrecuenciaConsumo consumoCarne;
    private FrecuenciaConsumo consumoLacteos;

    public Consumo(UsoPlastico usoPlastico, TipoRopa tipoRopa, FrecuenciaConsumo frecuenciaRopa,
            FrecuenciaConsumo consumoCarne, FrecuenciaConsumo consumoLacteos) {
        this.usoPlastico = usoPlastico;
        this.tipoRopa = tipoRopa;
        this.frecuenciaRopa = frecuenciaRopa;
        this.consumoCarne = consumoCarne;
        this.consumoLacteos = consumoLacteos;
    }

    public double calcularEmisionesPlastico() {
        return usoPlastico.getEmisiones();
    }

    public double calcularEmisionesRopa() {
        // emisiones por prenda * frecuencia semanal
        return tipoRopa.getEmisionesUnitarias() * frecuenciaRopa.getDias();
    }

    public double calcularEmisionesCarne() {
        // Ejemplo: cada día de consumo de carne = 7 kg CO₂
        return consumoCarne.getDias() * 7;
    }

    public double calcularEmisionesLacteos() {
        // Ejemplo: cada día de consumo de lácteos = 4 kg CO₂
        return consumoLacteos.getDias() * 4;
    }

    public double calcularTotalEmisionesConsumo() {
        return calcularEmisionesPlastico()
                + calcularEmisionesRopa()
                + calcularEmisionesCarne()
                + calcularEmisionesLacteos();
    }

    // Getters y Setters

    public UsoPlastico getUsoPlastico() {
        return usoPlastico;
    }

    public void setUsoPlastico(UsoPlastico usoPlastico) {
        this.usoPlastico = usoPlastico;
    }

    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public FrecuenciaConsumo getFrecuenciaRopa() {
        return frecuenciaRopa;
    }

    public void setFrecuenciaRopa(FrecuenciaConsumo frecuenciaRopa) {
        this.frecuenciaRopa = frecuenciaRopa;
    }

    public FrecuenciaConsumo getConsumoCarne() {
        return consumoCarne;
    }

    public void setConsumoCarne(FrecuenciaConsumo consumoCarne) {
        this.consumoCarne = consumoCarne;
    }

    public FrecuenciaConsumo getConsumoLacteos() {
        return consumoLacteos;
    }

    public void setConsumoLacteos(FrecuenciaConsumo consumoLacteos) {
        this.consumoLacteos = consumoLacteos;
    }

    @Override
    public String toString() {
        return "Emisiones Consumo {" +
                "\n  Plástico: " + calcularEmisionesPlastico() +
                "\n  Ropa: " + calcularEmisionesRopa() +
                "\n  Carne: " + calcularEmisionesCarne() +
                "\n  Lácteos: " + calcularEmisionesLacteos() +
                "\n  TOTAL: " + calcularTotalEmisionesConsumo() + " kg CO₂\n}";
    }
}
