package com.hackathon.agenda.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private int capacidadMaxima;

    public Agenda(int capacidadMaxima) {
        if (capacidadMaxima <= 0){
            throw new IllegalArgumentException("La capacidad debe ser mayor a cero");
        }
        this.contactos = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
    }

    public void aniadirContacto(Contacto contacto) {
        if (contacto == null ||
                contacto.getNombre() == null || contacto.getNombre().trim().isEmpty() ||
                contacto.getApellido() == null || contacto.getApellido().trim().isEmpty()) {
            System.out.println("Los nombres y apellidos no pueden estar vacíos.");
            return;
        }

        if (agendaLlena()) {
            System.out.println("La agenda está llena. No hay espacio disponible para nuevos contactos.");
            return;
        }

        if (existeContacto(contacto)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        contactos.add(contacto);
        System.out.println("Contacto añadido exitosamente.");
    }

    public boolean existeContacto(Contacto contacto) {
        if (contacto == null || contacto.getNombre() == null || contacto.getApellido() == null){
            return false;
        }
        return contactos.contains(contacto);
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        contactos.sort(Comparator.comparing((Contacto contacto) -> contacto.getNombre().toLowerCase())
                .thenComparing(contacto -> contacto.getApellido().toLowerCase()));


        for (Contacto contacto : contactos) {
            System.out.println(contacto.getNombre() + " " +
                    contacto.getApellido() + " - " + contacto.getTelefono());
        }
    }

    public void buscarContacto(String nombre, String apellido) {
        if (nombre == null || apellido == null){
            System.out.println("No se ha encontrado el contacto");
            return;
        }

        Contacto contactoBuscado = new Contacto(nombre, apellido, "");
        int posicionContacto = contactos.indexOf(contactoBuscado);

        if (posicionContacto != -1){
            System.out.println("Telefono: " + contactos.get(posicionContacto).getTelefono());
        } else {
            System.out.println("No se ha encontrado el contacto");
        }
    }

    public void eliminarContacto(Contacto contacto) {
        if (contacto != null && contacto.getNombre() != null &&
                contacto.getApellido() != null &&
                contactos.remove(contacto)){
            System.out.println("El contacto ha sido eliminado");
        } else {
            System.out.println("Ese contacto no existe");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        if (nombre == null || apellido == null) {
            System.out.println("El contacto no existe. No se puede modificar el teléfono.");
            return;
        }

        Contacto contactoBuscado = new Contacto(nombre, apellido, "");
        int posicionContacto = contactos.indexOf(contactoBuscado);

        if (posicionContacto != -1) {
            contactos.get(posicionContacto).setTelefono(nuevoTelefono);
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