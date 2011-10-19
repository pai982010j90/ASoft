package Clases;

import Humanos.Profesor;
import java.util.Date;
import java.util.*;
import Humanos.*;

public class Curso {

    private String nombre;
    private Date fechaInicio;
    private short duracion;
    private Profesor impartidoPor;
    private Collection<Alumno> impartidoA;

    public String getNombre() {
        return this.nombre;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public short getDuracion() {
        return this.duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    /**
     * 
     * @param nombre
     * @param fechaInicio
     * @param duracion
     */
    public Curso(String nombre, Date fechaInicio, short duracion, Profesor profesor) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        impartidoPor = profesor;
        
        impartidoA = new HashSet();
    }

    @Override
    public String toString() {
        String strFechaInicio = fechaInicio.getDate() + "/"
                + (fechaInicio.getMonth() + 1) + "/"
                + fechaInicio.getYear();

        return nombre + ", " + strFechaInicio
                + ", " + duracion + " horas";
    }

	/**
	 * 
	 * @param alumno
	 */
	public void matricularAlumno(Alumno alumno) {
		impartidoA.add(alumno);
	}
	public Collection getImpartidoA() {
		return impartidoA;
	}        
        
        public Profesor getImpartidoPor(){
            return impartidoPor;
        }
        
}