/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio15entregar;

import java.util.Scanner;

/**
 *
 * @author dam
 */
public class Ejercicio15 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nombreVendedor = "";
      
           System.out.println("hola");     
           
        float promedioVentasVendedor;
        int numeroVentasPequeno = 0, numeroVentasMediano = 0, numeroVentasGrande = 0;
        float totalVentasPequeno = 0, totalVentasMediano = 0, totalVentasGrande = 0;
        float importeVentas;
        int numeroVentas;
        float totalVentas = 0;
        float porcentajeVentasPequeno, porcentajeVentasMediano, porcentajeVentasGrande;
        String vendedorMasVentas = "", vendedorMenosVentas = "";
        float ventasPequena, ventasGrande;
        ventasPequena = Integer.MAX_VALUE;
        ventasGrande = Integer.MIN_VALUE;

        nombreVendedor = pedirNombre("Introduce el nombre del vendedor: ");
        nombreVendedor = nombreVendedor.toUpperCase();
        while (!nombreVendedor.equals("*")) {
            numeroVentas = pedirNumeroVentas("Introduce el número de ventas realizadas: ");
            // POR CADA VENDEDOR SOLO INTRODUZCO UNA VENTA.
            for (int i = 0; i < numeroVentas; i++) {
                importeVentas = pedirImporteVentas("Introduce el importe de dichas ventas: ");
                totalVentas = importeVentas + totalVentas;
            }

            if (totalVentas < ventasPequena) {
                ventasPequena = totalVentas;
                vendedorMenosVentas = nombreVendedor;
            }
            if (totalVentas > ventasGrande) {
                ventasGrande = totalVentas;
                vendedorMasVentas = nombreVendedor;
            }

            if (totalVentas < 5000) {
                numeroVentasPequeno++;
                totalVentasPequeno = totalVentasPequeno + totalVentas;

            } else {
                if (totalVentas <= 10000) {
                    numeroVentasMediano++;
                    totalVentasMediano = totalVentasMediano + totalVentas;
                } else {
                    numeroVentasGrande++;
                    totalVentasGrande = totalVentasGrande + totalVentas;
                }
            }

            nombreVendedor = pedirNombre("Introduce el nombre del vendedor: ");
            nombreVendedor = nombreVendedor.toUpperCase();
        } // FIN WHILE
        // DEBES DE CONTROLAR QUE NO DIVIDAS POR CERO
        porcentajeVentasPequeno = totalVentasPequeno / (float) totalVentas * 100;
        porcentajeVentasMediano = totalVentasMediano / (float) totalVentas * 100;
        porcentajeVentasGrande = totalVentasGrande / (float) totalVentas * 100;
// LA PREGUNTA DEBES DE REALIZARLA ANTES DE HACER EL CÁLCULO
        if (totalVentas == 0) {
            System.out.println("ERROR. El total de ventas es 0.");
        } else {
            System.out.println("INFORME DE VENDEDORES");
            System.out.println("Nombre del vendedor con MÁS ventas: " + vendedorMasVentas + "\t\tImporte: " + ventasGrande);
            System.out.println("Nombre del vendedor con MENOS ventas: " + vendedorMenosVentas + "\t\tImporte: " + ventasPequena);
            System.out.println("Promedio de ventas: ");
            System.out.println("IMPORTE VENTAS\t NÚMERO DE VENTAS\t TOTAL DE VENTAS\t PORCENTAJE (Sobre el total de ventas)");
            System.out.println("Menor de 5000€\t\t"
                    + numeroVentasPequeno + "\t\t\t" + totalVentasPequeno + "\t\t\t\t\t" + porcentajeVentasPequeno+"%");
            System.out.println("Entre 5000€ y 10000€\t"
                    + numeroVentasMediano + "\t\t\t" + totalVentasMediano + "\t\t\t\t\t" + porcentajeVentasMediano+"%");
            System.out.println("Más de 10000€\t\t"
                    + numeroVentasGrande + "\t\t\t" + totalVentasGrande + "\t\t\t\t\t" + porcentajeVentasGrande+"%");
        }
    }

    public static float pedirImporteVentas(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        float importe;
        System.out.println(mensaje);
        importe = teclado.nextFloat();
        while (importe < 0) {
            System.out.println("ERROR. Introduce un dato positivo.");
            System.out.println(mensaje);
            importe = teclado.nextFloat();
        }
        return importe;
    }

    public static int pedirNumeroVentas(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        int numero;
        System.out.println(mensaje);
        numero = teclado.nextInt();
        while (numero < 0) {
            System.out.println("ERROR. Introduce un dato positivo.");
            System.out.println(mensaje);
            numero = teclado.nextInt();
        }
        return numero;
    }

    public static String pedirNombre(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.println(mensaje);
        nombre = teclado.nextLine();
        while (nombre.trim().equals("")) {
            System.out.println("ERROR. El nombre introducido no es válido.");

            System.out.println(mensaje);
            nombre = teclado.nextLine();

        }
        return nombre;
    }
}
