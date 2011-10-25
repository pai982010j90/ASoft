package UI;

import Clases.*;
import Controllers.ASoftController;
import Humanos.*;
import java.util.*;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class CursoVista2 {

    Curso curso;
    //private SimpleTree arbol = new SimpleTree();
    private DefaultMutableTreeNode root;
    private ASoftController controlador;

    public CursoVista2(Curso curso, ASoftController controlador) {
        this.curso = curso;
        this.controlador = controlador;
    }

    public JTree mostrarCurso() {
        Profesor profe = curso.getImpartidoPor();



        root = new DefaultMutableTreeNode("Curso: " + curso.getNombre());
        //root.setUserObject("xxxxxxxxxx");
        root.add(new DefaultMutableTreeNode("Profesor: " + profe.getApellidos() + ", " + profe.getNombre()));
        
        mostrarAlumnos(root);
        DefaultMutableTreeNode nodos = mostrarExamenes(root, true);
        

        return new JTree(root);



    }

    public void mostrarAlumno(int dni) {
        //Alumno alumno = (Alumno) curso.getImpartidoA().get(dni);
        Alumno alumno = curso.getImpartidoA().get(dni);

        if (alumno != null) {
            System.out.println("(" + alumno.getDni() + ") - " + alumno.getApellidos() + ", " + alumno.getNombre());
        } else {
            System.out.println("No existe el alumno con DNI: " + dni);
        }

    }

    public void mostrarAlumnos(DefaultMutableTreeNode root) {
        Collection alumnos = curso.getImpartidoA().values();
        // Si hay alumnos
        //System.out.print("\tAlumnos: ");
        String tituloNodo = "Alumnos: ";


        int nAlumnos = alumnos.size();
        if (nAlumnos > 0) {
            tituloNodo += "(" + nAlumnos + ")";


            DefaultMutableTreeNode nodosAlumno = new DefaultMutableTreeNode(tituloNodo);
            /* No se puede iterar con un bucle mejorado pues no se utilizan genericos
             * y pide o un array o un iterable
             * //for(Alumno a: (Iterable)alumnos.iterator() ) 
             */

            for (Iterator i = alumnos.iterator(); i.hasNext();) {
                Alumno a = (Alumno) i.next();
                nodosAlumno.add(new DefaultMutableTreeNode(a.getApellidos() + ", " + a.getNombre()));
                //System.out.println("\t\t * " + a.getApellidos() + ", " + a.getNombre());
                nodosAlumno.setAllowsChildren(true);
            }
            root.add(nodosAlumno);

        } else {
            tituloNodo += "Sin alumnos";
        }

    }

    public DefaultMutableTreeNode mostrarExamenes(DefaultMutableTreeNode root, boolean recursivo) {
        DefaultMutableTreeNode nodos = null;
        
        Collection examenesConvocados = (Collection) curso.getExamenesConvocados();
        // Si hay alumnos
        String tituloNodo = "Examenes: ";
        //System.out.print("\tExamenes: ");
        int nExamenesConvocados = examenesConvocados.size();
        if (nExamenesConvocados > 0) {
            tituloNodo += "(" + nExamenesConvocados + ")";
            //System.out.print("(" + nExamenesConvocados + ")\n");
            nodos = new DefaultMutableTreeNode(tituloNodo);

            for (Iterator i = examenesConvocados.iterator(); i.hasNext();) {
                Examen e = (Examen) i.next();
                System.out.println("\t\t * " + e.getNombreModulo() + ", " + e.getFecha());
                DefaultMutableTreeNode nodoExamen = new DefaultMutableTreeNode(e.getNombreModulo() + ", " + e.getFecha());
                
                if (recursivo) {
                    mostrarCalificaciones(nodoExamen, e);
                }
                nodos.add(nodoExamen);
            }
        } else {
            System.out.println("Sin examenes");
        }
        root.add(nodos);
        return nodos;
    }

    public void mostrarCalificaciones(DefaultMutableTreeNode root, Examen examen) {
        SortedSet calificaciones = (SortedSet) examen.obtenerCalificaciones();
        // Si hay calificaciones
        String tituloNodo = "Calificaciones: ";
        //System.out.print("\t\t\tCalificaciones: ");
        DefaultMutableTreeNode nodos = new DefaultMutableTreeNode(tituloNodo);
        int nCalificaciones = calificaciones.size();
        if (nCalificaciones > 0) {
            tituloNodo += "(" + nCalificaciones + ")";
            //System.out.print("(" + nCalificaciones + ")\n");

            for (Iterator i = calificaciones.iterator(); i.hasNext();) {
                Calificacion c = (Calificacion) i.next();
                nodos.add(new DefaultMutableTreeNode(c.getNota() + ", " + c.getEvaluado()));
                //System.out.println("\t\t\t\t * " + c.getNota() + ", " + c.getEvaluado());
            }
            root.add(nodos);
        } else {
            System.out.println("Sin calificaciones");
        }
    }
}
