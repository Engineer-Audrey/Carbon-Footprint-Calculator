package com.audrey_brayan_sara_sebas_andres.Models;

public class HuellaCarbono {

        private double emisionesTransporte;
        private double emisionesVivienda;
        private double emisionesConsumo;
        private double huellaTotal;

        public HuellaCarbono(double emisionesTransporte, double emisionesVivienda, double emisionesConsumo) {
                this.emisionesTransporte = emisionesTransporte;
                this.emisionesVivienda = emisionesVivienda;
                this.emisionesConsumo = emisionesConsumo;
                this.huellaTotal = emisionesTransporte + emisionesVivienda + emisionesConsumo;
        }

        public void mostrarResultados() {
                System.out.println("  +-------------------------------------------------------+");
                System.out.println("  |                       Resultados                      |");
                System.out.println("  +-------------------------------------------------------+");
                System.out.println("  | La emisión de transporte es de: " + emisionesTransporte + " kg CO2");
                System.out.println("  | La emisión de vivienda es de: " + emisionesVivienda + " kg CO2");
                System.out.println("  | La emisión de consumo es de: " + emisionesConsumo + " kg CO2");
                System.out.println("  +-------------------------------------------------------+");
                System.out.println("  | Su huella total de carbono es: " + huellaTotal + " kg CO2");
                System.out.println("  +-------------------------------------------------------+");

                mostrarImpacto();
                mostrarRecomendaciones();
        }

        private void mostrarImpacto() {
                if (huellaTotal >= 0 && huellaTotal <= 5000) {
                        System.out.println("  | El impacto de tu huella de carbono es bajo");
                } else if (huellaTotal > 5000 && huellaTotal <= 10000) {
                        System.out.println("  | El impacto de tu huella de carbono es medio");
                } else {
                        System.out.println("  | El impacto de tu huella de carbono es alto");
                }
                System.out.println("  +-------------------------------------------------------+");
        }

        public HuellaCarbono(double huellaTotal) {
                this.huellaTotal = huellaTotal;
        }

        public double getHuellaTotal() {
                return huellaTotal;
        }

        public void mostrarRecomendaciones() {
                System.out.println();
                System.out.println(
                                "  +------------------------------------------------------------------------------------------+");
                System.out.println(
                                "  |                                      Recomendaciones                                     |");
                System.out.println(
                                "  +------------------------------------------------------------------------------------------+");

                if (huellaTotal < 5000) {
                        System.out.println(
                                        "  | - Optimiza el consumo de energía: Usa electrodomésticos de bajo consumo energético y     |");
                        System.out.println(
                                        "  | apaga luces y dispositivos electrónicos cuando no los estés utilizando.                  |");
                        System.out.println(
                                        "  | - Alimentación consciente: Compra productos locales y orgánicos.                         |");
                        System.out.println(
                                        "  | - Movilidad sostenible: Camina, usa bicicleta o transporte público.                      |");
                        System.out.println(
                                        "  | - Energías renovables: Si es posible, instala paneles solares o contrata energía verde.  |");
                } else if (huellaTotal < 9001) {
                        System.out.println(
                                        "  | - Transporte más eficiente: Cambia el carro por uno público, eléctrico o híbrido.        |");
                        System.out.println(
                                        "  | - Alimentación: Reduce el consumo de carne y opta por productos de temporada.            |");
                        System.out.println(
                                        "  | - Consumo consciente: Evita plásticos de un solo uso y recicla.                          |");
                        System.out.println(
                                        "  | - Revisa tu factura de energía: Usa bombillas LED y apaga equipos no usados.             |");
                } else if (huellaTotal < 10000) {
                        System.out.println(
                                        "  | - Revisión de la dieta: Reduce carne, especialmente de res.                              |");
                        System.out.println(
                                        "  | - Energía en el hogar: Sustituye electrodomésticos por modelos eficientes.               |");
                        System.out.println(
                                        "  | - Reducción del uso de vehículos: Prefiere transporte público o bicicletas.              |");
                        System.out.println(
                                        "  | - Compensación de emisiones: Participa en proyectos de reforestación.                    |");
                } else {
                        System.out.println(
                                        "  | - Cambio radical en la dieta: Adopta una dieta basada en plantas.                        |");
                        System.out.println(
                                        "  | - Opta por energías renovables: Usa paneles solares o energía verde.                     |");
                        System.out.println(
                                        "  | - Transporte responsable: Usa vehículo eléctrico o transporte público.                   |");
                        System.out.println(
                                        "  | - Optimiza tu hogar: Invierte en electrodomésticos clase A+++ y bombillas LED.           |");
                        System.out.println(
                                        "  | - Consumo responsable: Compra solo lo necesario y prioriza productos duraderos.          |");
                        System.out.println(
                                        "  | - Compensación de carbono: Invierte en proyectos ambientales.                            |");
                        System.out.println(
                                        "  | - Reduce vuelos: Prefiere viajes locales o terrestres.                                   |");
                }

                System.out.println(
                                "  +------------------------------------------------------------------------------------------+");
        }


}
