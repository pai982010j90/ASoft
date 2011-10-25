
import Clases.Curso;
import Controllers.ASoftController;
import UI.GraficoVista;
import UI.Menu;
import UI.TextoVista;
import UI.UIVista;
import Util.Varios;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nanohp
 */
public class ASoft3 {

    public static void main(String[] args) throws Exception {
        // Creo e inicializo el modelo:
        //Curso modelo = new Curso();
        //Curso modelo = Varios.inicializaDatosPrueba();
        Curso modelo = null;

        // la vista:
        Menu menu = new Menu();
        //UIVista vista = new TextoVista(menu);
        UIVista vista = new GraficoVista(menu);
        //InterfazVista vista = new InterfazTextualConversor();
        // y el control:
        ASoftController control = new ASoftController(vista, modelo);
        // configura la vista
        vista.setControlador(control);
        // y arranca la interfaz (vista):
        vista.arranca();
    }
}
