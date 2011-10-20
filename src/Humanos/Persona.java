package Humanos;

import Util.DNI;

public class Persona {

    private final DNI dni;
    private String nombre;
    private String apellidos;

    public Persona(DNI dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Persona)) {
            return false;
        }

        Persona other = (Persona) obj;
        if (this.dni != other.dni && (this.dni == null || !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.dni != null ? this.dni.hashCode() : 0);
        return hash;
    }

    /**
     * 
     * @param dni
     * @param nombre
     * @param apellidos
     */
    public DNI getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
}