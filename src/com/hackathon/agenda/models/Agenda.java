package com.hackathon.agenda.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda(int tamaño) {
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = tamaño;
    }

    public void añadirContacto(Contacto c) {
        if (c.getNombre() == null || c.getNombre().trim().isEmpty() ||
                c.getApellido() == null || c.getApellido().trim().isEmpty()) {
            System.out.println("Los nombres y apellidos no pueden estar vacíos.");
            return;
        }

        if (agendaLlena()) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
            return;
        }

        if (existeContacto(c)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        contactos.add(c);
        System.out.println("Contacto añadido exitosamente.");
    }

    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        contactos.sort(Comparator.comparing((Contacto c) -> c.getNombre().toLowerCase())
                .thenComparing(c -> c.getApellido().toLowerCase()));

        System.out.println("\n--- LISTA DE CONTACTOS ---");
        for (Contacto c : contactos) {
            System.out.println(c.toString());
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        Contacto contactoBuscado = new Contacto(nombre, apellido, "");
        int index = contactos.indexOf(contactoBuscado);
        if (index != -1) {
            System.out.println("Teléfono: " + contactos.get(index).getTelefono());
        } else {
            System.out.println("No se ha encontrado el contacto.");
        }
    }

    public void eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("El contacto ha sido eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar: El contacto no existe en la agenda.");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto contactoBuscado = new Contacto(nombre, apellido, "");
        int index = contactos.indexOf(contactoBuscado);

        if (index != -1) {
            contactos.get(index).setTelefono(nuevoTelefono);
            System.out.println("Teléfono modificado exitosamente.");
        } else {
            System.out.println("El contacto no existe. No se puede modificar el teléfono.");
        }
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espacioLibres() {
        return capacidadMaxima - contactos.size();
    }
}