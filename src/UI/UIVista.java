/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.Curso;
import Controllers.ASoftController;

/**
 *
 * @author nanohp
 */
public interface UIVista {

    public final static String MUESTRA_CURSO = "Mostrar Todo";

    public void arranca();

    public void muestraMenuPrincipal();

    public void muestraCurso(Curso curso);

    public void setControlador(ASoftController aSoftController); //muestraFormulario(Object);
}
