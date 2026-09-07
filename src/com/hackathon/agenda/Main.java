package com.hackathon.agenda;

import com.hackathon.agenda.models.Contacto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista temporal mientras se integra la clase Agenda
        ArrayList<Contacto> contactos = new ArrayList<>();

        // Capacidad provisional
        int capacidadMaxima = 10;

        int tecladoOpcion;

        do {

            System.out.println();
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

            // Consume el Enter pendiente
            scanner.nextLine();

            switch (tecladoOpcion) {

                case 1:
                    System.out.println();
                    System.out.println("=== AÑADIR CONTACTO ===");

                    if (contactos.size() >= capacidadMaxima) {
                        System.out.println("La agenda está llena.");
                        break;
                    }

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa el número del contacto: ");
                    String numero = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, numero);

                    boolean contactoExiste = false;

                    for (Contacto contacto : contactos) {

                        if (contacto.equals(nuevoContacto)) {
                            contactoExiste = true;
                            break;
                        }
                    }

                    if (contactoExiste) {

                        System.out.println("El contacto ya existe.");

                    } else {

                        contactos.add(nuevoContacto);
                        System.out.println("Contacto agregado correctamente.");
                        System.out.println(nuevoContacto);
                    }

                    break;

                case 2:
                    System.out.println();
                    System.out.println("=== COMPROBAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreComprobar = scanner.nextLine();

                    boolean existe = false;

                    for (Contacto contacto : contactos) {

                        if (contacto.getNombre().equalsIgnoreCase(nombreComprobar)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("El contacto sí existe.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }

                    break;

                case 3:
                    System.out.println();
                    System.out.println("=== LISTA DE CONTACTOS ===");

                    if (contactos.isEmpty()) {

                        System.out.println("No hay contactos registrados.");

                    } else {

                        for (Contacto contacto : contactos) {
                            System.out.println(contacto);
                        }
                    }

                    break;

                case 4:
                    System.out.println();
                    System.out.println("=== BUSCAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreBuscar = scanner.nextLine();

                    Contacto contactoEncontrado = null;

                    for (Contacto contacto : contactos) {

                        if (contacto.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            contactoEncontrado = contacto;
                            break;
                        }
                    }

                    if (contactoEncontrado != null) {

                        System.out.println("Contacto encontrado:");
                        System.out.println(contactoEncontrado);

                    } else {

                        System.out.println("Contacto no encontrado.");
                    }

                    break;

                case 5:
                    System.out.println();
                    System.out.println("=== ELIMINAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    Contacto contactoEliminar = null;

                    for (Contacto contacto : contactos) {

                        if (contacto.getNombre().equalsIgnoreCase(nombreEliminar)) {
                            contactoEliminar = contacto;
                            break;
                        }
                    }

                    if (contactoEliminar != null) {

                        contactos.remove(contactoEliminar);
                        System.out.println("Contacto eliminado correctamente.");

                    } else {

                        System.out.println("El contacto no existe.");
                    }

                    break;

                case 6:
                    System.out.println();
                    System.out.println("=== ESTADO DE LA AGENDA ===");

                    if (contactos.size() >= capacidadMaxima) {

                        System.out.println("La agenda está llena.");

                    } else {

                        System.out.println("La agenda todavía tiene espacio.");
                    }

                    break;

                case 7:
                    System.out.println();
                    System.out.println("=== ESPACIOS LIBRES ===");

                    int espaciosLibres = capacidadMaxima - contactos.size();

                    System.out.println(
                            "Espacios disponibles: " + espaciosLibres
                    );

                    break;

                case 0:
                    System.out.println();
                    System.out.println("¡Gracias por usar nuestra agenda telefónica!");
                    break;

                default:
                    System.out.println();
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (tecladoOpcion != 0);

        scanner.close();
    }
}