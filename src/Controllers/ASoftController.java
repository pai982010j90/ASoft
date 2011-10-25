package Controllers;

import Clases.Curso;
import UI.CursoVista;
import UI.UIVista;
import Util.Varios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author nanohp
 */
public class ASoftController implements ActionListener, FocusListener, ItemListener, ComponentListener, MenuKeyListener, MouseListener, TreeSelectionListener {
//public class ASoftController implements ActionListener, MenuKeyListener, MouseListener, EventListener {

    private UIVista vista;
    private Curso modelo;

    public ASoftController(UIVista vista, Curso modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        System.err.println("dfs" + modelo);
        if (modelo != null) {
            if (evento.getActionCommand().equals(UIVista.MUESTRA_CURSO)) {
                vista.muestraCurso(modelo);

            } else if (evento.getActionCommand().equals("Serializar Curso")) {
                try {
                    System.err.println("Serializar Curso");
                    Curso.serializarCurso(modelo);
                } catch (Exception ex) {
                    Logger.getLogger(ASoftController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (evento.getActionCommand().equals("Inicializacion interna")) {
                try {
                    System.err.println("Inicializando Curso");
                    modelo = Varios.inicializaDatosPrueba();
                } catch (Exception ex) {
                    Logger.getLogger(ASoftController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (evento.getActionCommand().equals("Deserializar Curso")) {
                try {
                    System.err.println("Deserializar Curso");
                    modelo = Curso.deSerializarCurso();
                } catch (Exception ex) {
                    Logger.getLogger(ASoftController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (evento.getActionCommand().equals("Salir")) {
            System.exit(0);
        }


    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        System.err.println(ie.getItem());
    }

    @Override
    public void componentResized(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void menuKeyTyped(MenuKeyEvent mke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void menuKeyPressed(MenuKeyEvent mke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void menuKeyReleased(MenuKeyEvent mke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void focusGained(FocusEvent fe) {
        System.err.println("Foco");
    }

    @Override
    public void focusLost(FocusEvent fe) {
        System.err.println("Sin Foco");
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.err.println("Click el raton" + me.toString());
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.err.println("Presionando el raton");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.err.println("Soltando el raton");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.err.println("Entrado el raton");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.err.println("Saliendo el raton");
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        System.err.println("a" + e);
    }
}
