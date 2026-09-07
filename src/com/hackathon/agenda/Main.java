package com.hackathon.agenda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int tecladoOpcion;

        do {

            System.out.println("=== AGENDA TELEFÓNICA ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Comprobar si existe un contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Comprobar si la agenda está llena");
            System.out.println("7. Mostrar espacios libres");
            System.out.println("0. Salir");

            System.out.print("Selecciona una opción: ");
            tecladoOpcion = scanner.nextInt();
            scanner.nextLine();

            switch (tecladoOpcion) {

                case 1:
                    System.out.println("Elegiste añadir contacto");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Nombre ingresado: " + nombre);

                    System.out.print("Ingresa el nunero del contacto: ");
                    String numero = scanner.nextLine();

                    System.out.println("Numero ingresado: " + numero);
                    break;

                case 2:
                    System.out.println("Elegiste comprobar si existe un contacto");
                    break;

                case 3:
                    System.out.println("Elegiste listar contactos");
                    break;

                case 4:
                    System.out.println("Elegiste buscar contacto");
                    break;

                case 5:
                    System.out.println("Elegiste eliminar contacto");
                    break;

                case 6:
                    System.out.println("Elegiste comprobar si la agenda está llena");
                    break;

                case 7:
                    System.out.println("Elegiste mostrar espacios libres");
                    break;

                case 0:
                    System.out.println("¡Gracias por usar nuestra agenda telefónica!");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (tecladoOpcion != 0);

    }
}