/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programa_tienda;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Programa_tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> carrito = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion(sc);
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = Double.parseDouble(sc.nextLine());
                    agregarProducto(carrito, precio);
                    break;

                case 3:
                    pagar(carrito, sc);
                    break;

                case 4:
                    salir = true;
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opción invalida.");
            }
        }

        sc.close();
    }
    // Método para mostrar el menú
    static void mostrarMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Agregar producto");
        System.out.println("3. Pagar");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    // Método para leer la opción del usuario
    static int leerOpcion(Scanner sc) {
        int opcion;
        opcion = Integer.parseInt(sc.nextLine());
        return opcion;
    }

    // Método para agregar un producto al carrito
    static void agregarProducto(List<Double> carrito, double precio) {
        carrito.add(precio);
        System.out.println("Producto agregado: $" + precio);
    }

    // Método que calcula el total con impuesto
    static double total(double base, double imp) {
        return base + (base * imp);
    }

    // Método para confirmar la compra
    static void confirmarCompra(double total) {
        System.out.println("\n----- REPORTE DE COMPRA -----");
        System.out.println("Total pagado: $" + String.format("%.2f", total));
    }

    // Método para realizar el pago
    static void pagar(List<Double> carrito, Scanner sc) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito esta vacio. No hay nada que pagar.");
            return;
        }

        // Calcular subtotal
        double subtotal = 0;
        for (double precio : carrito) {
            subtotal += precio;
        }

        double impuesto = 0.15;
        double totalConImpuesto = total(subtotal, impuesto);

        System.out.println("\nSubtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Impuesto (15%): $" + String.format("%.2f", subtotal * impuesto));
        System.out.println("TOTAL: $" + String.format("%.2f", totalConImpuesto));

        confirmarCompra(totalConImpuesto);

        // Vaciar carrito después del pago
        carrito.clear();
    }
}
