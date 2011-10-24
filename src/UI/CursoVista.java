package UI;

import Clases.*;
import Humanos.*;
import java.util.*;

public class CursoVista {

    Curso curso;

    public CursoVista(Curso curso) {
        this.curso = curso;
    }

    public void mostrarCurso() {
        Profesor profe = curso.getImpartidoPor();

        System.out.println("Curso: " + curso.getNombre());
        System.out.println("\tProfesor: " + profe.getApellidos() + ", " + profe.getNombre());
        mostrarAlumnos();
        mostrarExamenes(true);



    }

    public void mostrarAlumno(int dni) {
       // Alumno alumno = (Alumno) curso.getImpartidoA().get(dni);
         Alumno alumno = (Alumno) curso.getImpartidoA().get(dni);
        if (alumno != null) {
            System.out.println("(" + alumno.getDni() + ") - " + alumno.getApellidos() + ", " + alumno.getNombre());
        } else {
            System.out.println("No existe el alumno con DNI: " + dni);
        }

    }

    public void mostrarAlumnos() {
        Collection alumnos = curso.getImpartidoA().values();
        // Si hay alumnos
        System.out.print("\tAlumnos: ");
        int nAlumnos = alumnos.size();
        if (nAlumnos > 0) {
            System.out.print("(" + nAlumnos + ")\n");
            /* No se puede iterar con un bucle mejorado pues no se utilizan genericos
             * y pide o un array o un iterable
             * //for(Alumno a: (Iterable)alumnos.iterator() ) 
             */

            for (Iterator i = alumnos.iterator(); i.hasNext();) {
                Alumno a = (Alumno) i.next();
                System.out.println("\t\t * " + a.getApellidos() + ", " + a.getNombre());
            }
        } else {
            System.out.println("Sin alumnos");
        }
    }

    public void mostrarExamenes(boolean recursivo) {
        Collection examenesConvocados = (Collection) curso.getExamenesConvocados();
        // Si hay alumnos
        System.out.print("\tExamenes: ");
        int nExamenesConvocados = examenesConvocados.size();
        if (nExamenesConvocados > 0) {
            System.out.print("(" + nExamenesConvocados + ")\n");

            for (Iterator i = examenesConvocados.iterator(); i.hasNext();) {
                Examen e = (Examen) i.next();
                System.out.println("\t\t * " + e.getNombreModulo() + ", " + e.getFecha());
                if (recursivo) {
                    mostrarCalificaciones(e);
                }
            }
        } else {
            System.out.println("Sin examenes");
        }
    }

    public void mostrarCalificaciones(Examen examen) {
        SortedSet calificaciones = (SortedSet) examen.obtenerCalificaciones();
        // Si hay calificaciones
        System.out.print("\t\t\tCalificaciones: ");
        int nCalificaciones = calificaciones.size();
        if (nCalificaciones > 0) {
            System.out.print("(" + nCalificaciones + ")\n");

            for (Iterator i = calificaciones.iterator(); i.hasNext();) {
                Calificacion c = (Calificacion) i.next();
                System.out.println("\t\t\t\t * " + c.getNota() + ", " + c.getEvaluado());
            }
        } else {
            System.out.println("Sin calificaciones");
        }
    }
}
