/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author nanohp
 */
public class DialogoCampoVista extends Vista {

    private String etiqueta;

    public DialogoCampoVista(String titulo, String etiqueta) {
        super(titulo);
        this.etiqueta = etiqueta;
    }

    public String ejecutaVista() {
        mostrarTitulo();
        return solicitaCampo(etiqueta);
    }
}
