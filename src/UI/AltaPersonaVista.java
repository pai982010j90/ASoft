package UI;

import Humanos.Persona;
import Util.DNI;
import Util.DNINoValidoException;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AltaPersonaVista extends Vista{

    private String tipo;

    public AltaPersonaVista(String titulo, String tipo) {
        super(titulo);
        this.tipo = tipo;
    }
    


    public Persona ejecutaVista() {
        
        mostrarTitulo();
        
        int numeroDNI = Integer.parseInt(solicitaCampo("Numero DNI: "));
        char letra = solicitaCampo("Letra DNI: ").charAt(0);
        String nombre = solicitaCampo("Nombre: ");
        String apellidos = solicitaCampo("Apellidos: ");
        
        
        
        Persona persona = null;
        try {
            persona = new Persona(new DNI(numeroDNI, letra), nombre, apellidos);
        } catch (DNINoValidoException ex) {
            System.err.println("Error semantico en la construcción del DNI (numero y letra)");
        } catch (IllegalArgumentException ex) {
            System.err.println("Numero de DNI fuera de rango");
        }

        return persona;
    }

}
