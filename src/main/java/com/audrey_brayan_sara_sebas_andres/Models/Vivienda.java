package com.audrey_brayan_sara_sebas_andres.Models;

public class Vivienda {

    private Estrato estrato;
    private double consumoElectricidad; // kWh mensuales
    private double consumoGas; // m³ mensuales
    private double consumoAgua; // m³ mensuales
    private TipoGas tipoGas;

    public Vivienda(Estrato estrato, double consumoElectricidad, double consumoGas, double consumoAgua,
            TipoGas tipoGas) {
        this.estrato = estrato;
        this.consumoElectricidad = consumoElectricidad;
        this.consumoGas = consumoGas;
        this.consumoAgua = consumoAgua;
        this.tipoGas = tipoGas;
    }

    public double calcularEmisionesElectricidad() {
        // Ejemplo: cada kWh = 0.0007 toneladas CO₂
        return consumoElectricidad * estrato.getCostoKWh() * 0.0007;
    }

    public double calcularEmisionesGas() {
        if (tipoGas == TipoGas.NINGUNO) {
            return 0;
        }
        // Cada m³ de gas = 0.002 toneladas CO₂
        return consumoGas * estrato.getCostoGas() * 0.002;
    }

    public double calcularEmisionesAgua() {
        // Cada m³ de agua = 0.0003 toneladas CO₂
        return consumoAgua * estrato.getCostoAgua() * 0.0003;
    }

    public double calcularTotalEmisionesVivienda() {
        return calcularEmisionesElectricidad() + calcularEmisionesGas() + calcularEmisionesAgua();
    }

    // Getters y Setters

    public Estrato getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato estrato) {
        this.estrato = estrato;
    }

    public double getConsumoElectricidad() {
        return consumoElectricidad;
    }

    public void setConsumoElectricidad(double consumoElectricidad) {
        this.consumoElectricidad = consumoElectricidad;
    }

    public double getConsumoGas() {
        return consumoGas;
    }

    public void setConsumoGas(double consumoGas) {
        this.consumoGas = consumoGas;
    }

    public double getConsumoAgua() {
        return consumoAgua;
    }

    public void setConsumoAgua(double consumoAgua) {
        this.consumoAgua = consumoAgua;
    }

    public TipoGas getTipoGas() {
        return tipoGas;
    }

    public void setTipoGas(TipoGas tipoGas) {
        this.tipoGas = tipoGas;
    }

    @Override
    public String toString() {
        return "Emisiones Vivienda {" +
                "\n  Estrato: " + estrato +
                "\n  Electricidad: " + calcularEmisionesElectricidad() +
                "\n  Gas: " + calcularEmisionesGas() +
                "\n  Agua: " + calcularEmisionesAgua() +
                "\n  TOTAL: " + calcularTotalEmisionesVivienda() + " kg CO₂\n}";
    }
}
