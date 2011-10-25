package UI;

import java.io.*;

/**
 *
 * @author nanohp
 */
public class Vista {

    protected String titulo;

    public Vista(String titulo) {
        this.titulo = titulo;
    }

    public void mostrarTitulo() {
        System.out.println(titulo);
    }

    protected String solicitaCampo(String etiqueta) {
        // Muestra la etiqueta:
        System.out.print(etiqueta);

        // Pedir el campo
        String campo = null;
        try {
            // Preparamos el flujo para lectura desde el teclado
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            // Leemos desde el teclado
            campo = br.readLine();
            System.out.print("\n");
        } catch (IOException ex) {
            System.err.println("Fallo en la lectura del campo:" + etiqueta);
        }
        return campo;
    }
}
