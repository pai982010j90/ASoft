package Humanos;

import Util.DNI;
import Clases.*;
import java.util.*;

public class Alumno extends Persona{

    private Curso cursa;
    Collection<Calificacion> calificaciones;

    public Alumno(DNI dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
        calificaciones = new HashSet();
    }

    @Override
    public String toString() {
        return "Alumno{" + super.toString() + "}";
    }

    public void setCursa(Curso cursa) {
        this.cursa = cursa;
    }

    public Curso getCursa() {
        return cursa;
    }

    public void agregaCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    public Collection obtenerCalificaciones() {
        return calificaciones;
    }
/*
    @Override
    public int compareTo(Object o) {
        // Verifico si puede comparar
        if (o == null) {
            throw new IllegalArgumentException();
        }

        Alumno p = (Alumno) o;
        return this.getDni().compareTo(p.getDni());
    }
     * 
     */
}