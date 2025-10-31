package com.audrey_brayan_sara_sebas_andres;

import java.util.Scanner;
import com.audrey_brayan_sara_sebas_andres.Models.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================================");
        System.out.println("|         CALCULADORA DE HUELLA DE CARBONO                |");
        System.out.println("===========================================================\n");

        // === TRANSPORTE ===
        System.out.println("=== TRANSPORTE ===");

        boolean tieneVehiculo = leerRespuestaBoolean("¿Tiene vehículo personal? (Si/No): ", sc);

        TipoVehiculo tipoVehiculo = TipoVehiculo.NINGUNO;
        double kmVehiculo = 0;

        if (tieneVehiculo) {
            System.out.print("Tipo de vehículo (CARRO / MOTO): ");
            tipoVehiculo = TipoVehiculo.valueOf(sc.nextLine().toUpperCase());

            System.out.print("¿Cuántos km recorre al día en su vehículo?: ");
            kmVehiculo = sc.nextDouble();
            sc.nextLine();
        }

        boolean usaTP = leerRespuestaBoolean("¿Usa transporte público? (Si/No): ", sc);

        double kmTP = 0;
        if (usaTP) {
            System.out.print("¿Cuántos km recorre al día en transporte público?: ");
            kmTP = sc.nextDouble();
            sc.nextLine();
        }

        boolean viajaAvion = leerRespuestaBoolean("¿Viaja en avión? (Si/No): ", sc);

        int viajesAvion = 0;
        if (viajaAvion) {
            System.out.print("¿Cuántos vuelos realiza al año?: ");
            viajesAvion = sc.nextInt();
            sc.nextLine();
        }

        Transporte transporte = new Transporte(
                tieneVehiculo, tipoVehiculo, kmVehiculo,
                usaTP, kmTP, viajaAvion, viajesAvion);

        double emisionesTransporte = transporte.calcularTotalEmisionesTransporte();
        System.out.println("\n" + transporte + "\n");

        // === VIVIENDA ===
        System.out.println("=== VIVIENDA ===");

        System.out.print("Ingrese su estrato (1 - 6): ");
        int numeroEstrato = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Estrato estrato = obtenerEstratoPorNumero(numeroEstrato);

        System.out.print("Consumo mensual de electricidad (kWh): ");
        double consumoElect = sc.nextDouble();

        System.out.print("Consumo mensual de gas (m³): ");
        double consumoGas = sc.nextDouble();

        System.out.print("Consumo mensual de agua (m³): ");
        double consumoAgua = sc.nextDouble();
        sc.nextLine();

        System.out.print("Tipo de gas (NATURAL / CILINDRO / NINGUNO): ");
        TipoGas tipoGas = TipoGas.valueOf(sc.nextLine().toUpperCase());

        Vivienda vivienda = new Vivienda(estrato, consumoElect, consumoGas, consumoAgua, tipoGas);
        double emisionesVivienda = vivienda.calcularTotalEmisionesVivienda();

        System.out.println("\n" + vivienda + "\n");

        // === CONSUMO PERSONAL ===
        System.out.println("=== CONSUMO PERSONAL ===");

        System.out.print("Frecuencia de uso de plástico (DIARIO, SEMANAL, RARA_VEZ, NINGUNO): ");
        UsoPlastico usoPlastico = UsoPlastico.valueOf(sc.next().toUpperCase());

        System.out.print("Tipo de ropa que más usa (IMPORTADA, NACIONAL, SEGUNDA_MANO, REUTILIZADA): ");
        TipoRopa tipoRopa = TipoRopa.valueOf(sc.next().toUpperCase());

        System.out.print("Frecuencia de compra de ropa (DIARIO, CUATRO_SEIS, UNO_TRES, NINGUNO): ");
        FrecuenciaConsumo freqRopa = FrecuenciaConsumo.valueOf(sc.next().toUpperCase());

        System.out.print("Frecuencia de consumo de carne (DIARIO, CUATRO_SEIS, UNO_TRES, NINGUNO): ");
        FrecuenciaConsumo freqCarne = FrecuenciaConsumo.valueOf(sc.next().toUpperCase());

        System.out.print("Frecuencia de consumo de lácteos (DIARIO, CUATRO_SEIS, UNO_TRES, NINGUNO): ");
        FrecuenciaConsumo freqLacteos = FrecuenciaConsumo.valueOf(sc.next().toUpperCase());

        Consumo consumo = new Consumo(usoPlastico, tipoRopa, freqRopa, freqCarne, freqLacteos);
        double emisionesConsumo = consumo.calcularTotalEmisionesConsumo();

        System.out.println("\n" + consumo + "\n");

        // === RESULTADOS ===
        HuellaCarbono huella = new HuellaCarbono(emisionesTransporte, emisionesVivienda, emisionesConsumo);

        System.out.println("\n===========================================================");
        huella.mostrarResultados();
        System.out.println("===========================================================\n");

        sc.close();
    }

    // === MÉTODO AUXILIAR: CONVERSIÓN DE NÚMERO A ESTRATO ===
    private static Estrato obtenerEstratoPorNumero(int numeroEstrato) {
        switch (numeroEstrato) {
            case 1:
                return Estrato.UNO;
            case 2:
                return Estrato.DOS;
            case 3:
                return Estrato.TRES;
            case 4:
                return Estrato.CUATRO;
            case 5:
                return Estrato.CINCO;
            case 6:
                return Estrato.SEIS;
            default:
                System.out.println("Número inválido, se asignará estrato UNO por defecto.");
                return Estrato.UNO;
        }
    }

    // === MÉTODO AUXILIAR: LECTURA DE RESPUESTAS SI/NO ===
    private static boolean leerRespuestaBoolean(String mensaje, Scanner sc) {
        System.out.print(mensaje);
        String respuesta = sc.nextLine().trim().toUpperCase();
        while (!respuesta.equals("SI") && !respuesta.equals("NO")) {
            System.out.print("Por favor responda 'Si' o 'No': ");
            respuesta = sc.nextLine().trim().toUpperCase();
        }
        return respuesta.equals("SI");
    }
}
