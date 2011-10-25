/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.*;
import Controllers.ASoftController;
import Humanos.*;
import java.awt.event.ActionEvent;
//import UI.*;

/**
 *
 * @author nanohp
 */
public class TextoVista implements UIVista{

    private ASoftController controlador;
    private Menu menu;

    public TextoVista(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void arranca() {
        arrancaMenu();
    }

    @Override
    public void muestraMenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void arrancaMenu() {
        int opcion = -1;

        do {
            menu.mostrarItems();
            menu.mostrarSelectorOpcion();
            opcion = menu.getOpcion();
            procesaOpcionMenu(opcion);

        } while (opcion > 0);
    }

    public void procesaOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                controlador.actionPerformed(new ActionEvent(this, opcion, UIVista.MUESTRA_CURSO));
                break;
            case 2:
                controlador.actionPerformed(new ActionEvent(this, opcion, "Serializar Curso"));
                
                //serializarCurso(cursoPAI);
                break;
            case 3:
                controlador.actionPerformed(new ActionEvent(this, opcion, "Deserializar Curso"));
                break;
            case 4:
                //cursoPAI = inicializaDatosPrueba();
                break;

            case 5:
                DialogoCampoVista dcv = new DialogoCampoVista("Que alumno busca?", "DNI - Alumno: ");
                int numDNIAlumno = Integer.parseInt(dcv.ejecutaVista());
                Alumno alumno = null;
                //Alumno alumno = cursoPAI.getImpartidoA().get(numDNIAlumno);
                if (alumno != null) {
                    System.out.println(alumno.getNombre());
                } else {
                    System.out.println("No existe el alumno con DNI:" + numDNIAlumno);
                }

                break;

            case 6:
                AltaPersonaVista avp = new AltaPersonaVista("Alta de Persona", "Alumno");
                Persona p = new Alumno(avp.ejecutaVista());
                //cursoPAI.matricularAlumno((Alumno) p);

                break;


            default:
                assert false : "Opcion de menu no controlada";
        }
    }

    public void muestraCurso(Curso curso) {
        CursoVista cursoVista = new CursoVista(curso);
        cursoVista.mostrarCurso();
    }

    public void setControlador(ASoftController aSoftController) {
        this.controlador = aSoftController;
    }

}
