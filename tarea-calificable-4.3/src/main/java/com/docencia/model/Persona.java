package com.docencia.model;

import java.util.Objects;

public class Persona {

    private final int id;
    private String nombre;

    public Persona(int id) {
        this.id = id;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return id == persona.id && Objects.equals(nombre, persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", nombre='" + getNombre() + "'"
                + "}";
    }

}
