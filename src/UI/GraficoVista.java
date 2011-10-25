/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Clases.Curso;
import Controllers.ASoftController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author nanohp
 */
public class GraficoVista extends JFrame implements UIVista {

    private Menu menuOpciones;
    //Where the GUI is created:
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    JButton boton1;
    private ASoftController controlador;

    public GraficoVista(Menu menuOpciones) {
        super("ASoft");

        this.menuOpciones = menuOpciones;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipalCentro = new JPanel();
        JPanel panelPrincipalSouth = new JPanel();

        setLayout(new BorderLayout(10, 10));
        boton1 = new JButton("A euros");
        panelPrincipalCentro.add(boton1, BorderLayout.CENTER);
        getContentPane().add(panelPrincipalCentro, BorderLayout.CENTER);
        //getContentPane().add(panelPrincipalSouth, BorderLayout.SOUTH);

    }

    @Override
    public void arranca() {
        creaMenuPrincipal1();
        pack();// coloca los componentes
        setLocationRelativeTo(null);// centra la ventana en la pantalla
        setVisible(true);// visualiza la ventana
    }

    @Override
    public void muestraMenuPrincipal() {
    }

    @Override
    public void muestraCurso(Curso curso) {
   
        CursoVista2 cv2 = new CursoVista2(curso, controlador);
        JTree st = cv2.mostrarCurso();
        st.addFocusListener(controlador);
        st.addMouseListener(controlador);
        //st.addTreeSelectionListener(controlador);
       
        
        JPanel center_panel = new JPanel();
        center_panel.add(st);
        
        //JDialog dialog = new JDialog((Frame) null, "fs");
        JDialog dialog = new JDialog((Frame) this, true);
        dialog.getContentPane().add(center_panel, BorderLayout.CENTER);
        dialog.setTitle("Cursos");
        //getContentPane().add(dialog);
        dialog.pack();
        dialog.setVisible(true);



    }

    @Override
    public void setControlador(ASoftController aSoftController) {
        controlador = aSoftController;
        boton1.addActionListener(controlador);

    }

    private void creaMenuPrincipal1() {
        Map<String, String> menuCompleto = menuOpciones.getItems();
        Set<String> claveItemOpcion = menuOpciones.getItems().keySet();
        //Collection <String > itemsMenu = menuOpciones.getItems().values();

        //Create the menu bar.
        menuBar = new JMenuBar();
        menu = new JMenu("Menu Unico");
        menuBar.add(menu);

        for (String clave : claveItemOpcion) {

            menuItem = new JMenuItem(menuCompleto.get(clave));
            //System.err.println("-" + menuCompleto.get(clave));
            //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
            //menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
            menuItem.addActionListener(controlador);
            /*menuItem.addItemListener(controlador);
            menuItem.addComponentListener(controlador);
            menuItem.addMenuKeyListener(controlador);*/
            //System.err.println(menuItem.getActionListeners());
            menu.add(menuItem);
        }

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }
}
