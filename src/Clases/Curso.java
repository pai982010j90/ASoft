package Clases;

import Humanos.Profesor;
import java.util.Date;
import java.util.*;
import Humanos.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Curso implements Serializable {

    private String nombre;
    private Date fechaInicio;
    private short duracion;
    private Profesor impartidoPor;
    //private Collection impartidoA;
    private Map<Integer, Alumno> impartidoA;
    private Collection<Examen> examenesConvocados;

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

        /* Cambiamos la instanciacion de HashSet --> TreeSet para que manejar a 
         * a la coleccion como ordenada
         * * impartidoA = new HashSet();
         */

        //impartidoA = new TreeSet();
        impartidoA = new HashMap<Integer, Alumno>();
        //examenesConvocados = new HashSet();
        //examenesConvocados = new TreeSet();
        examenesConvocados = new ArrayList<Examen>();
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
        //impartidoA.add(alumno);
        impartidoA.put(alumno.getDni().getNumero(), alumno);
    }

    public Map<Integer, Alumno> getImpartidoA() {
        return impartidoA;
    }

    public Profesor getImpartidoPor() {
        return impartidoPor;
    }

    public void setImpartidoPor(Profesor profesor) {
        impartidoPor = profesor;
    }

    public void convocarExamen(Examen examen) {
        examenesConvocados.add(examen);
    }

    public Collection getExamenesConvocados() {
        return examenesConvocados;
    }

    public Curso getCurso() {
        return this;
    }

    public static void serializarCurso(Curso curso) throws Exception {
        FileOutputStream fos = new FileOutputStream("asoft.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(curso);
        oos.close();
    }

    public static Curso deSerializarCurso() throws Exception {
        Curso curso = null;

        FileInputStream fis = new FileInputStream("asoft.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        curso = (Curso) ois.readObject();
        ois.close();

        return curso;
    }
}