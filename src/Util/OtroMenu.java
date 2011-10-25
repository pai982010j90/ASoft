/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Util.menuBar;
import javax.swing.*;

/**
 *
 * @author nanohp
 */
public class OtroMenu {
    public void creaMenu() {
        //Create the menu bar.
        menuBar = new JMenuBar();
//Build the first menu.
        menu = new JMenu("A Menu");

        menu.setMnemonic(KeyEvent.VK_A);

        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
//a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);

        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);
        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));

        menuItem.setMnemonic(KeyEvent.VK_B);

        menu.add(menuItem);
        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));

        menuItem.setMnemonic(KeyEvent.VK_D);

        menu.add(menuItem);

//a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");

        rbMenuItem.setSelected(
                true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);

        group.add(rbMenuItem);

        menu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Another one");

        rbMenuItem.setMnemonic(KeyEvent.VK_O);

        group.add(rbMenuItem);

        menu.add(rbMenuItem);

//a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");

        cbMenuItem.setMnemonic(KeyEvent.VK_C);

        menu.add(cbMenuItem);
        cbMenuItem = new JCheckBoxMenuItem("Another one");

        cbMenuItem.setMnemonic(KeyEvent.VK_H);

        menu.add(cbMenuItem);

//a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");

        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("An item in the submenu");

        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem = new JMenuItem("Another item");

        submenu.add(menuItem);

        menu.add(submenu);
//Build second menu in the menu bar.
        menu = new JMenu("Another Menu");

        menu.setMnemonic(KeyEvent.VK_N);

        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);


        setJMenuBar(menuBar);
    }
}
