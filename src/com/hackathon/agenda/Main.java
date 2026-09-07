package com.hackathon.agenda;

import com.hackathon.agenda.models.Agenda;
import com.hackathon.agenda.models.Contacto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Agenda agenda = new Agenda(10);

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

            scanner.nextLine();

            switch (tecladoOpcion) {

                case 1:
                    System.out.println();
                    System.out.println("=== AÑADIR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingresa el apellido del contacto: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingresa el número del contacto: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevoContacto =
                            new Contacto(nombre, apellido, telefono);

                    agenda.aniadirContacto(nuevoContacto);

                    break;

                case 2:
                    System.out.println();
                    System.out.println("=== COMPROBAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreComprobar = scanner.nextLine();

                    System.out.print("Ingresa el apellido del contacto: ");
                    String apellidoComprobar = scanner.nextLine();

                    Contacto contactoComprobar =
                            new Contacto(nombreComprobar, apellidoComprobar);

                    if (agenda.existeContacto(contactoComprobar)) {
                        System.out.println("El contacto sí existe.");
                    } else {
                        System.out.println("El contacto no existe.");
                    }

                    break;

                case 3:
                    System.out.println();
                    System.out.println("=== LISTA DE CONTACTOS ===");

                    agenda.listarContactos();

                    break;

                case 4:
                    System.out.println();
                    System.out.println("=== BUSCAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreBuscar = scanner.nextLine();

                    System.out.print("Ingresa el apellido del contacto: ");
                    String apellidoBuscar = scanner.nextLine();

                    agenda.buscarContacto(
                            nombreBuscar,
                            apellidoBuscar
                    );

                    break;

                case 5:
                    System.out.println();
                    System.out.println("=== ELIMINAR CONTACTO ===");

                    System.out.print("Ingresa el nombre del contacto: ");
                    String nombreEliminar = scanner.nextLine();

                    System.out.print("Ingresa el apellido del contacto: ");
                    String apellidoEliminar = scanner.nextLine();

                    Contacto contactoEliminar =
                            new Contacto(nombreEliminar, apellidoEliminar);

                    agenda.eliminarContacto(contactoEliminar);

                    break;

                case 6:
                    System.out.println();
                    System.out.println("=== ESTADO DE LA AGENDA ===");

                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda todavía tiene espacio.");
                    }

                    break;

                case 7:
                    System.out.println();
                    System.out.println("=== ESPACIOS LIBRES ===");

                    System.out.println(
                            "Espacios disponibles: " + agenda.espacioLibres()
                    );

                    break;

                case 0:
                    System.out.println();
                    System.out.println(
                            "¡Gracias por usar nuestra agenda telefónica!"
                    );
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