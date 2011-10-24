package Humanos;

import Util.DNI;
import java.io.Serializable;

public class Persona implements Comparable, Serializable {

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

    @Override
    public int compareTo(Object o) {
        // Verificacion si puede comparar
        if (o == null || !(this.getClass().getName().equals(o.getClass().getName()))) {
            //if (o == null || !(o instanceof Persona) ){
            throw new IllegalArgumentException();
        }

        Persona p = (Persona) o;
        /* Si quisieras fijar como criterio de ordenacion natural el DNI, podemos
         * aprovechar el metodo del "compareTo" de dicha clase, siempre que 
         * lo hayamos definido previamente
         *      return this.getDni().compareTo(p.getDni());
         */

        // El criterio de ordenacion natural elegido es: apellidos, nombre
        int comparaApellidos = this.getApellidos().compareTo(p.getApellidos());
        /*
         * Comparación con esquema clasico if-else
         * 
         */

        /*if (comparaApellidos != 0) {return comparaApellidos;}
        return this.getNombre().compareTo(p.getNombre());
         */

        // Comparación con operador ternario
        return comparaApellidos != 0 ? comparaApellidos
                : this.getNombre().compareTo(p.getNombre());
    }
}