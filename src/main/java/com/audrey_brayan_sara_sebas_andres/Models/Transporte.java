package com.audrey_brayan_sara_sebas_andres.Models;

public class Transporte {

    private boolean tieneVehiculoPersonal;
    private TipoVehiculo tipoVehiculo;
    private double kmDiariosVehiculo;
    private boolean usaTransportePublico;
    private double kmDiariosTransportePublico;
    private boolean viajaEnAvion;
    private int viajesAnualesAvion;

    public Transporte(boolean tieneVehiculoPersonal, TipoVehiculo tipoVehiculo, double kmDiariosVehiculo,
            boolean usaTransportePublico, double kmDiariosTransportePublico,
            boolean viajaEnAvion, int viajesAnualesAvion) {
        this.tieneVehiculoPersonal = tieneVehiculoPersonal;
        this.tipoVehiculo = tipoVehiculo;
        this.kmDiariosVehiculo = kmDiariosVehiculo;
        this.usaTransportePublico = usaTransportePublico;
        this.kmDiariosTransportePublico = kmDiariosTransportePublico;
        this.viajaEnAvion = viajaEnAvion;
        this.viajesAnualesAvion = viajesAnualesAvion;
    }

    public double calcularEmisionesVehiculo() {
        if (!tieneVehiculoPersonal || tipoVehiculo == TipoVehiculo.NINGUNO) {
            return 0;
        }
        // kmDiarios * 365 * factor del enum
        return kmDiariosVehiculo * 365 * tipoVehiculo.getFactorEmision();
    }

    public double calcularEmisionesTransportePublico() {
        if (!usaTransportePublico) {
            return 0;
        }
        // 0.05 toneladas por km anual (según tu pseudocódigo)
        return kmDiariosTransportePublico * 365 * 0.05;
    }

    public double calcularEmisionesAvion() {
        if (!viajaEnAvion) {
            return 0;
        }
        // 900 kg CO₂ por vuelo (según tu pseudocódigo)
        return viajesAnualesAvion * 900;
    }

    public double calcularTotalEmisionesTransporte() {
        return calcularEmisionesVehiculo() + calcularEmisionesTransportePublico() + calcularEmisionesAvion();
    }

    // Getters y Setters

    public boolean isTieneVehiculoPersonal() {
        return tieneVehiculoPersonal;
    }

    public void setTieneVehiculoPersonal(boolean tieneVehiculoPersonal) {
        this.tieneVehiculoPersonal = tieneVehiculoPersonal;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getKmDiariosVehiculo() {
        return kmDiariosVehiculo;
    }

    public void setKmDiariosVehiculo(double kmDiariosVehiculo) {
        this.kmDiariosVehiculo = kmDiariosVehiculo;
    }

    public boolean isUsaTransportePublico() {
        return usaTransportePublico;
    }

    public void setUsaTransportePublico(boolean usaTransportePublico) {
        this.usaTransportePublico = usaTransportePublico;
    }

    public double getKmDiariosTransportePublico() {
        return kmDiariosTransportePublico;
    }

    public void setKmDiariosTransportePublico(double kmDiariosTransportePublico) {
        this.kmDiariosTransportePublico = kmDiariosTransportePublico;
    }

    public boolean isViajaEnAvion() {
        return viajaEnAvion;
    }

    public void setViajaEnAvion(boolean viajaEnAvion) {
        this.viajaEnAvion = viajaEnAvion;
    }

    public int getViajesAnualesAvion() {
        return viajesAnualesAvion;
    }

    public void setViajesAnualesAvion(int viajesAnualesAvion) {
        this.viajesAnualesAvion = viajesAnualesAvion;
    }

    @Override
    public String toString() {
        return "Emisiones Transporte {" +
                "\n  Vehículo personal: " + (tieneVehiculoPersonal ? tipoVehiculo : "No tiene") +
                "\n  Emisiones vehículo: " + calcularEmisionesVehiculo() +
                "\n  Emisiones transporte público: " + calcularEmisionesTransportePublico() +
                "\n  Emisiones avión: " + calcularEmisionesAvion() +
                "\n  TOTAL: " + calcularTotalEmisionesTransporte() + " kg CO₂\n}";
    }
}
